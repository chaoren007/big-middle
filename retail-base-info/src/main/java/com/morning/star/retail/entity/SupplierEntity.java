package com.morning.star.retail.entity;

import com.morning.star.retail.admin.dto.AccountSupplierAddDTO;
import com.morning.star.retail.admin.enums.AccountLevelEnum;
import com.morning.star.retail.facade.dto.SupplierWmsDTO;
import com.morning.star.retail.util.RandomUtil;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 供应商-实体
 *
 * @author jiangyf
 */
@Entity
@Table(name = "retail_supplier")
@Where(clause = "delete_flag <> 1")
@Data
public class SupplierEntity extends BaseEntity {
	private static final long serialVersionUID = 4505193978818395702L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment(value = "供应商编码")
	@Column(length = 32, unique = true)
	private String supplierCode;

	@Comment(value = "供应商名称")
	@Column(length = 64)
	private String supplierName;

	@Comment(value = "联系人姓名")
	@Column(length = 32)
	private String linkman;

	@Comment(value = "联系方式")
	@Column(length = 18)
	private String contact;

	@Comment(value = "手机号")
	@Column(length = 11)
	private String mobile;

	@Comment(value = "经营品类id")
	@Column(length = 20)
	private Long categoryId;

	@Comment(value = "经营品类名称")
	@Column(length = 32)
	private String categoryName;

	@Comment(value = "所属省份id")
	@Column(length = 20)
	private Long provinceId;

	@Comment(value = "所属省份名称")
	@Column(length = 32)
	private String provinceName;

	@Comment(value = "所属城市id")
	@Column(length = 20)
	private Long cityId;

	@Comment(value = "所属城市编码")
	@Column(length = 32)
	private String cityCode;

	@Comment(value = "所属城市名称")
	@Column(length = 32)
	private String cityName;

	@Comment(value = "常驻城市id")
	@Column(length = 20)
	private Long permanentCityId;

	@Comment(value = "常驻城市名称")
	@Column(length = 32)
	private String permanentCityName;

	@Comment(value = "合同年份")
	@Column(length = 11)
	private Integer contractYear;

	@Comment(value = "营业执照")
	@Column(length = 100)
	private String businessLicense;

	@Comment(value = "授权证书")
	@Column(length = 100)
	private String authority;

	@Comment(value = "身份证正面")
	@Column(length = 100)
	private String idcardFront;

	@Comment(value = "身份证背面")
	@Column(length = 100)
	private String idcardBack;

	@Comment("供应商类别编码")
	@Column(length = 32)
	private String typeCode;

	@Comment("供应商类别名称")
	@Column(length = 32)
	private String typeName;

	@Comment(value = "状态")
	@Column(length = 2)
	private Integer status;

	@Comment(value = "备注")
	@Column(length = 100)
	private String remark;

	@Comment(value = "门店编码")
	@Column(nullable = false, length = 32)
	private String storeCode;

	@Comment(value = "集团编码")
	@Column(nullable = false, length = 32)
	private String groupCode;

	@Comment(value = "集团名称")
	@Column(length = 64)
	private String groupName;

	@Comment("供应商类型（0：总部；1：分公司）")
	@Column(length = 32)
	private Integer type;

	public static SupplierWmsDTO toWmsDTO(SupplierEntity entity) {
		if (entity == null) {
			return null;
		}
		SupplierWmsDTO wms = new SupplierWmsDTO();
		wms.setSupplierCode(entity.getSupplierCode());
		wms.setSupplierName(entity.getSupplierName());
		wms.setLinkman(entity.getLinkman());
		wms.setPushType("S");
		wms.setCityId(entity.getCityId());
		wms.setCityName(entity.getCityName());
		wms.setCityCode(entity.getCityCode());

		return wms;
	}


	public static AccountSupplierAddDTO toAccountDTO(SupplierEntity entity) {
		if (entity == null) {
			return null;
		}
		AccountSupplierAddDTO account = new AccountSupplierAddDTO();
		account.setSupplierCode(entity.getSupplierCode());
		account.setSupplierName(entity.getSupplierName());
		account.setGroupCode(entity.getGroupCode());
		account.setGroupName(entity.getGroupName());
		account.setAccount(entity.getMobile());
		account.setMobile(entity.getMobile());
		account.setPassword(RandomUtil.generateString(12));
		account.setAccountLevel(AccountLevelEnum.SUPPLIER.getCode());

		return account;
	}
}
