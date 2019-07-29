package com.morning.star.retail.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "retail_address")
@Data
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = -2415654623413404712L;

    @Id
    private long addressId;
    @Column(length = 11)
    private int addressLevel;
    @Column(length = 20)
    private long parentAddressId;
    @Column(length = 64)
    private String addressName;
    @Column(length = 128)
    private String path;
    @Column(length = 64)
    private String zipCode;
    @Column(length = 128)
    private String pathCh;
    @Column(length = 64)
    private String addressCode;
    @Column(length = 64)
    private String addressAttr;
    @Comment("大区编码")
    @Column(length = 64)
    private String regionCode;
    @Comment("大区名称")
    @Column(length = 64)
    private String regionName;
    @Comment("大区绑定标记")
    @Column(length = 64)
    private Integer regionBind = 0;
}
