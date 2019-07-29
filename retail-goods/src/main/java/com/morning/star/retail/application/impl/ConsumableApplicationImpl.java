package com.morning.star.retail.application.impl;

import com.morning.star.retail.application.ConsumableApplication;
import com.morning.star.retail.entity.ConsumableEntity;
import com.morning.star.retail.entity.ConsumableWaterEntity;
import com.morning.star.retail.entity.repository.ConsumableRepository;
import com.morning.star.retail.entity.repository.WaterRepository;
import com.morning.star.retail.facade.dto.ConsumableAddDTO;
import com.morning.star.retail.facade.dto.ConsumableImportDTO;
import com.morning.star.retail.facade.dto.ConsumableUseReturnDTO;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/8/7 14:18
 */
@Service
public class ConsumableApplicationImpl implements ConsumableApplication {

	@Autowired
	private ConsumableRepository consumableRepository;
	@Autowired
	private WaterRepository waterRepository;

	@Override
	@Transactional
	public void addConsumable(List<ConsumableAddDTO> dtos) {
		Validate.notEmpty(dtos, "添加数据没有");
		dtos.forEach(e -> {
			Validate.isTrue(!consumableRepository.existsByConsumableCode(e.getConsumableCode()),
				"该耗材编码已存在：" + e.getConsumableCode());
			ConsumableEntity consumableEntity = new ConsumableEntity();
			BeanUtils.copy(e, consumableEntity);
			consumableRepository.save(consumableEntity);

			waterRepository.save(consumableEntity, ConsumableWaterEntity.class, "创建耗材");
		});
	}

	@Override
	@Transactional
	public void importConsumable(List<ConsumableImportDTO> dtos) {
		Validate.notEmpty(dtos, "添加数据没有");
		dtos.forEach(e -> {
			ConsumableEntity consumableEntity = consumableRepository.getByConsumableCode(e.getConsumableCode());
			if (consumableEntity != null) {
				Integer consumableNum = consumableEntity.getConsumableNum() + e.getConsumableNum();
				consumableEntity.setConsumableNum(consumableNum);
				consumableRepository.save(consumableEntity);
				waterRepository.save(consumableEntity, ConsumableWaterEntity.class, "添加耗材：" + e.getConsumableNum());
			}
		});
	}

	@Override
	@Transactional
	public void useConsumable(ConsumableUseReturnDTO dto) {
		ConsumableEntity consumableEntity = consumableRepository.getByConsumableCode(dto.getConsumableCode());
		Validate.notNull(consumableEntity, "该耗材信息不存在：" + dto.getConsumableCode());
		new UserPermission(UserUtils.currentUser()).tag("groupCode", consumableEntity.getGroupCode())
			.msg("不允许借用该耗材：" + dto.getConsumableCode())
			.pass();

		Validate.isTrue(consumableEntity.getConsumableNum() >= dto.getConsumableNum(),
			"耗材数量不足");
		Integer consumableNum = consumableEntity.getConsumableNum() - dto.getConsumableNum();
		consumableEntity.setConsumableNum(consumableNum);
		consumableRepository.save(consumableEntity);
		waterRepository.save(consumableEntity, ConsumableWaterEntity.class, "耗材借用：" + dto.getConsumableNum());
	}

	@Override
	public void backConsumable(ConsumableUseReturnDTO dto) {
		ConsumableEntity consumableEntity = consumableRepository.getByConsumableCode(dto.getConsumableCode());
		Validate.notNull(consumableEntity, "该耗材信息不存在：" + dto.getConsumableCode());
		new UserPermission(UserUtils.currentUser()).tag("groupCode", consumableEntity.getGroupCode())
			.msg("不允许借用该耗材：" + dto.getConsumableCode())
			.pass();

		Integer consumableNum = consumableEntity.getConsumableNum() + dto.getConsumableNum();
		consumableEntity.setConsumableNum(consumableNum);
		consumableRepository.save(consumableEntity);
		waterRepository.save(consumableEntity, ConsumableWaterEntity.class, "耗材归还：" + dto.getConsumableNum());
	}
}
