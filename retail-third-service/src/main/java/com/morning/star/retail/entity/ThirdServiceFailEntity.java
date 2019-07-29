package com.morning.star.retail.entity;

import com.morning.star.retail.entity.enums.RequestStatusEnum;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.entity.enums.RequestTypeEnum;
import com.morning.star.retail.facade.dto.ThirdServiceFailDTO;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_third_service_fail")
@Where(clause = "delete_flag <> 1")
public class ThirdServiceFailEntity extends BaseEntity {
	private static final long serialVersionUID = 559028683041454996L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 19)
	private Long id;

	@Comment("请求链接")
	@Column
	private String requestApi;

	@Comment("请求参数")
	@Column(length = 1000)
	private String requestParam;

	@Comment("错误原因信息")
	@Column(length = 1000)
	private String msg;

	@Comment("请求服务类型")
	@Column(length = 2, nullable = false)
	@Convert(converter = RequestTypeEnum.DBConverter.class)
	private RequestTypeEnum requestType;

	@Comment("请求服务标示")
	@Column(length = 2, nullable = false)
	@Convert(converter = RequestTagEnum.DBConverter.class)
	private RequestTagEnum requestTag;

	@Comment("请求服务状态")
	@Column(length = 2, nullable = false)
	@Convert(converter = RequestStatusEnum.DBConverter.class)
	private RequestStatusEnum requestStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestApi() {
		return requestApi;
	}

	public void setRequestApi(String requestApi) {
		this.requestApi = requestApi;
	}

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public RequestTypeEnum getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestTypeEnum requestType) {
		this.requestType = requestType;
	}

	public RequestTagEnum getRequestTag() {
		return requestTag;
	}

	public void setRequestTag(RequestTagEnum requestTag) {
		this.requestTag = requestTag;
	}

	public RequestStatusEnum getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatusEnum requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public static ThirdServiceFailDTO toDTO(ThirdServiceFailEntity entity) {
		if(entity == null) {
			return null;
		}
		ThirdServiceFailDTO dto = new ThirdServiceFailDTO();
		BeanUtils.copy(entity, dto);
		return dto;
	}
}
