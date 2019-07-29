package com.morning.star.retail.admin.entity;


import com.morning.star.retail.admin.utils.audit.Operator;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;

@Table(name = "retail_account_supplier")
@Where(clause = "delete_flag <> 1")
@Entity
@Data
public class SupplierAccountEntity extends BaseEntity {

	private static final long serialVersionUID = 1111320370190733557L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Comment("集团编码")
	@Column(length = 64)
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Column(length = 64)
	@Comment("门店编码")
	private String storeCode;

	@Column(length = 64)
	@Comment("门店名称")
	private String storeName;

	@Column(length = 64)
	@Comment("供应商编码")
	private String supplierCode;

	@Column(length = 64)
	@Comment("供应商名称")
	private String supplierName;

	@Comment("账号")
	@Column(name = "account", nullable = false)
	private String account;

	@Comment("密码")
	@Column(name = "password", nullable = false)
	private String password;

	@Comment("盐值")
	@Column(name = "salt", nullable = false)
	private String salt;

	@Comment("联系人姓名")
	@Column(name = "name")
	private String name;

	@Comment("联系人手机")
	private String mobile;

	@Comment("联系人邮箱")
	private String email;

	@Comment("账号等级")
	@Column(nullable = false)
	private String accountLevel;

	@Comment("权限")
	private String accessIds;

	@Comment("是否在线（0：离线；1：在线）")
	@Column(length = 2)
	private Integer isOnline;

	@Comment("状态（0：正常；1：冻结；2：作废）")
	@Column(name = "status", nullable = false, length = 2)
	private Integer status;

	@Comment("登录次数")
	private Integer loginCount;

	@Comment("上次登录时间")
	private Date lastLoginTime;

	@Comment("头像")
	private String icon;

	/**
	 * 创建人
	 */
	@CreatedBy
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "operatorId", column = @Column(name = "creator_id")),
		@AttributeOverride(name = "operatorName", column = @Column(name = "creator_name"))
	})
	private Operator creator;
}
