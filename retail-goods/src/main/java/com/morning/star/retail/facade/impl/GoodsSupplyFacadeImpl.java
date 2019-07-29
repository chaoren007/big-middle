package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.GoodsSupplyApplication;
import com.morning.star.retail.dao.GoodsSupplyDAO;
import com.morning.star.retail.entity.GoodsSupplyEntity;
import com.morning.star.retail.entity.GoodsSupplySetEntity;
import com.morning.star.retail.entity.GoodsSupplyWaterEntity;
import com.morning.star.retail.entity.ProductImgEntity;
import com.morning.star.retail.entity.repository.GoodsSupplyRepository;
import com.morning.star.retail.entity.repository.GoodsSupplySetRepository;
import com.morning.star.retail.entity.repository.GoodsSupplyWaterRepository;
import com.morning.star.retail.entity.repository.ProductImgRepository;
import com.morning.star.retail.enums.GoodsSupplyStatus;
import com.morning.star.retail.enums.ProductImgType;
import com.morning.star.retail.facade.GoodsSupplyFacade;
import com.morning.star.retail.facade.assembler.GoodsSupplyAssembler;
import com.morning.star.retail.facade.dto.BusGoodsOnOffDTO;
import com.morning.star.retail.facade.dto.ProductSpecDTO;
import com.morning.star.retail.facade.dto.supply.*;
import com.morning.star.retail.listener.mq.CreateSupplyGoodsSender;
import com.morning.star.retail.listener.mq.OnOffSaleSupplyGoodsSender;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author ethan
 * @create_time 2019/3/11 16:46
 */
@Service
public class GoodsSupplyFacadeImpl implements GoodsSupplyFacade {
	@Autowired
	private GoodsSupplyApplication goodsSupplyApplication;
	@Autowired
	private GoodsSupplyWaterRepository goodsSupplyWaterRepository;

	@Autowired
	private GoodsSupplyRepository goodsSupplyRepository;
	@Autowired
	private ProductImgRepository productImgRepository;
	@Autowired
	private GoodsSupplySetRepository goodsSupplySetRepository;

	@Autowired
	private GoodsSupplyDAO goodsSupplyDAO;

	@Autowired
	private CreateSupplyGoodsSender createSupplyGoodsSender;
	@Autowired
	private OnOffSaleSupplyGoodsSender onOffSaleSupplyGoodsSender;

	@Override
	public void draft(GoodsSupplySubmitDTO dto) {
		goodsSupplyApplication.submit(dto, GoodsSupplyStatus.DRAFT);
	}

	@Override
	public void submit(GoodsSupplySubmitDTO dto) {
		GoodsSupplyDTO goodsSupplyDTO = goodsSupplyApplication.submit(dto, GoodsSupplyStatus.SUBMIT);
		// 发送商品创建消息
		createSupplyGoodsSender.send(goodsSupplyDTO);
	}

	@Override
	public GoodsSupplyDTO getDetailBySupplyCode(String code) {
		List<GoodsSupplyEntity> entityList = goodsSupplyRepository.findByGoodsSupplyCode(code);
		GoodsSupplyDTO resultDTO = GoodsSupplyAssembler.builderDTO(entityList, false);
		fillImg(resultDTO);
		return resultDTO;

	}

	@Override
	public GoodsSupplyDTO getDetailBySupplyCodeV2(String code) {
		List<GoodsSupplyEntity> entityList = goodsSupplyRepository.findByGoodsSupplyCode(code);
		GoodsSupplyDTO resultDTO = GoodsSupplyAssembler.builderDTO(entityList, true);
		fillImg(resultDTO);
		return resultDTO;
	}

	@Override
	public GoodsSupplyDTO getDetailByProductCode(String code) {
		GoodsSupplyEntity entity = goodsSupplyRepository.findByProductCode(code);
		GoodsSupplyDTO resultDTO = new GoodsSupplyDTO();
		BeanUtils.copy(entity, resultDTO);
		if (StringUtils.isNotBlank(entity.getSpuInfo())) {
			resultDTO.setProductSpecInfo(ProductSpecDTO.builderList(entity.getSpuInfo()));
		}
		if (StringUtils.isNotBlank(entity.getCategorySpuInfo())) {
			resultDTO.setCategorySpuInfoList(ProductSpecDTO.builderList(entity.getCategorySpuInfo()));
		}
		resultDTO.setAreaDetailList(entity.getAreaDetail().stream().map(area -> {
			GoodsSupplySetDTO areaDTO = new GoodsSupplySetDTO();
			BeanUtils.copy(area, areaDTO);
			return areaDTO;
		}).collect(Collectors.toList()));
		fillImg(resultDTO);
		return resultDTO;
	}

	@Override
	public PageBean<GoodsSupplyDTO> page(GoodsSupplyQueryDTO queryDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
		Page<GoodsSupplyDTO> pageList = goodsSupplyDAO.page(queryDTO, rowBounds);
		pageList.getResult().forEach(e -> {
			if (e.getSupplyCityIds().split(",").length > 1) {
				e.setSupplyCityType("MANY");
			} else {
				e.setSupplyCityType("SINGLE");
			}
		});
		return new PageBeanAssembler().toBean(pageList);
	}

	@Override
	public PageBean<GoodsSupplyBusDTO> busPage(GoodsSupplyQueryDTO queryDTO) {
		PageBean<GoodsSupplySimpleDTO> pageList = pageBySpu(queryDTO);
		List<GoodsSupplyBusDTO> result = new ArrayList<>();

		for (GoodsSupplySimpleDTO e : pageList.getRecord()) {
			GoodsSupplyBusDTO goodsSupplyBusDTO = new GoodsSupplyBusDTO();
			BeanUtils.copy(e, goodsSupplyBusDTO);
			// 如果查询城市 则把城市价格和库存添加上
			if (StringUtils.isNotBlank(queryDTO.getCityId())) {
				// 如果是多规格
				if (e.getDetail() != null && e.getDetail().size() > 0) {
					goodsSupplyBusDTO.setDetail(e.getDetail().stream().map(dtoDetail -> {
						GoodsSupplyBusDTO detail = new GoodsSupplyBusDTO();
						BeanUtils.copy(dtoDetail, detail);
						// 把每个规格的城市价格和库存查找并设置上
						GoodsSupplySetEntity setEntity = goodsSupplySetRepository.findByProductCodeAndCityId(dtoDetail.getProductCode(), Long.valueOf(queryDTO.getCityId()));
						if (setEntity != null) {
							detail.setCityPrice(setEntity.getPrice());
							detail.setCityStockNum(setEntity.getTotalNum());
						}
						return detail;
					}).collect(Collectors.toList()));
				} else {
					// 单规格直接把城市价格和库存查找并设置上
					GoodsSupplySetEntity setEntity = goodsSupplySetRepository.findByProductCodeAndCityId(e.getProductCode(), Long.valueOf(queryDTO.getCityId()));
					if (setEntity != null) {
						goodsSupplyBusDTO.setCityPrice(setEntity.getPrice());
						goodsSupplyBusDTO.setCityStockNum(setEntity.getTotalNum());
					}
				}
			}
			result.add(goodsSupplyBusDTO);
		}

		return new PageBean<>(pageList.getTotalNum(), result, pageList.getPageNo(), pageList.getPageSize(), pageList.getPages());
	}

	@Override
	public PageBean<GoodsSupplySimpleDTO> pageBySpu(GoodsSupplyQueryDTO queryDTO) {
		queryDTO.setMainSpu("1");
		PageBean<GoodsSupplyDTO> pageList = page(queryDTO);

		List<GoodsSupplySimpleDTO> result = new ArrayList<>();
		for (GoodsSupplyDTO e : pageList.getRecord()) {
			GoodsSupplySimpleDTO simpleDTO = new GoodsSupplySimpleDTO();
			BeanUtils.copy(e, simpleDTO);

			// 如果是多规格商品,获取相关规格数据
			if (StringUtils.isNotBlank(e.getSpuCode())) {
				List<GoodsSupplyEntity> entityList = goodsSupplyRepository.findBySpuCode(e.getSpuCode());

				simpleDTO.setDetail(entityList.stream()
					.filter(entity -> entity.getMainSpu().equals(0))
					.map(entity -> {
						GoodsSupplySimpleDTO detail = new GoodsSupplySimpleDTO();
						BeanUtils.copy(entity, detail);
						return detail;
					}).collect(Collectors.toList()));
			} else {
				simpleDTO.setDetail(Collections.EMPTY_LIST);
			}
			result.add(simpleDTO);
		}
		return new PageBean<>(pageList.getTotalNum(), result, pageList.getPageNo(), pageList.getPageSize(), pageList.getPages());
	}

	@Override
	public void auditFail(GoodsSupplyAuditDTO dto) {
		goodsSupplyApplication.audit(dto, GoodsSupplyStatus.NO_PASS);
	}

	@Override
	public void auditSuccess(GoodsSupplyAuditDTO dto) {
		goodsSupplyApplication.audit(dto, GoodsSupplyStatus.ON_SALE);
		if (StringUtils.isNotBlank(dto.getGoodsSupplyCode())) {
			onOffSaleSupplyGoodsSender.send(BusGoodsOnOffDTO.builderAuditOn(dto.getGoodsSupplyCode()));
		} else {
			dto.getGoodsSupplyCodeSet().forEach(code -> {
				onOffSaleSupplyGoodsSender.send(BusGoodsOnOffDTO.builderAuditOn(code));
			});
		}

	}

	@Override
	public void onSale(GoodsSupplyAuditDTO dto) {
		goodsSupplyApplication.audit(dto, GoodsSupplyStatus.ON_SALE);
		if (StringUtils.isNotBlank(dto.getGoodsSupplyCode())) {
			onOffSaleSupplyGoodsSender.send(BusGoodsOnOffDTO.builderOn(dto.getGoodsSupplyCode()));
		} else {
			dto.getGoodsSupplyCodeSet().forEach(code -> {
				onOffSaleSupplyGoodsSender.send(BusGoodsOnOffDTO.builderOn(code));
			});
		}
	}

	@Override
	public void offSale(GoodsSupplyAuditDTO dto) {
		goodsSupplyApplication.audit(dto, GoodsSupplyStatus.OFF_SALE);
		if (StringUtils.isNotBlank(dto.getGoodsSupplyCode())) {
			onOffSaleSupplyGoodsSender.send(BusGoodsOnOffDTO.builderOff(dto.getGoodsSupplyCode()));
		} else {
			dto.getGoodsSupplyCodeSet().forEach(code -> {
				onOffSaleSupplyGoodsSender.send(BusGoodsOnOffDTO.builderOff(code));
			});
		}
	}

	@Override
	public void openGroup(GoodsSupplyAuditGroupDTO dto) {
		goodsSupplyApplication.auditGroup(dto, GoodsSupplyStatus.OPEN_GROUP);
	}

	@Override
	public void closeGroup(GoodsSupplyAuditGroupDTO dto) {
		goodsSupplyApplication.auditGroup(dto, GoodsSupplyStatus.ON_SALE);
	}

	@Override
	public List<GoodsSupplyLogDTO> getOperateLog(GoodsSupplyQueryDTO queryDTO) {
		List<GoodsSupplyWaterEntity> entityList = goodsSupplyWaterRepository.findByProductCode(queryDTO.getProductCode());
		entityList.sort((GoodsSupplyWaterEntity a, GoodsSupplyWaterEntity b) -> b.getId().compareTo(a.getId()));
		return entityList.stream().map(e -> {
			GoodsSupplyLogDTO log = new GoodsSupplyLogDTO();
			if(e.getOperator() != null) {
				BeanUtils.copy(e.getOperator(), log);
			}
			BeanUtils.copy(e, log);
			return log;
		}).collect(Collectors.toList());
	}

	@Override
	public void saleOutStock(List<GoodsSupplyStockReduceDTO> dtoList) {
		goodsSupplyApplication.saleOutStock(dtoList);
	}

	@Override
	public void remove(GoodsSupplyDelDTO dto) {
		goodsSupplyApplication.remove(dto);
	}

	/**
	 * 获取商品图片信息，填写入商品信息中
	 */
	private void fillImg(GoodsSupplyDTO dto) {
		List<ProductImgEntity> imgList = productImgRepository.getBySapProductCode(dto.getGoodsSupplyCode());
		Map<ProductImgType, List<ProductImgEntity>> groupImgList = imgList.stream().collect(groupingBy(ProductImgEntity::getImgType));
		if (groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.ATLAS, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			dto.setImgPaths(imgPathStr);
		}
		if (groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList()).size() > 0) {
			String imgPathStr = String.join(",", groupImgList.getOrDefault(ProductImgType.INTRODUCE, Collections.emptyList())
				.stream()
				.map(ProductImgEntity::getImgUri)
				.collect(Collectors.toList()));
			dto.setIntroImgPaths(imgPathStr);
		}
	}
}
