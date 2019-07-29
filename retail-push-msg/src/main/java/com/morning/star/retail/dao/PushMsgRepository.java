package com.morning.star.retail.dao;

import com.morning.star.retail.entity.PushMsgEntity;
import com.morning.star.retail.enums.PushMsgStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dell on 2018/7/17.
 */
public interface PushMsgRepository extends JpaRepository<PushMsgEntity, String> {

	PushMsgEntity getByMsgCode(String code);

	List<PushMsgEntity> getByUinAndStatus(Long uin, PushMsgStatus status);
}
