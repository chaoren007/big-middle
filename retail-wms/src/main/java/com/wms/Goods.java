
package com.wms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Goods complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Goods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FModifyTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROPORTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bzq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checkmode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dosekind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fresh_check" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gatherlv" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="goods_abc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goods_flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goods_high" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="goods_long" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="goods_weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="goods_width" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="incode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isfresh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isweigh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jbdw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lot2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxrackfloor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="midpackqty" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="minpackqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="minrackfloor" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="msgid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mulpackage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packbarcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="packunit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="picklv" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="pname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recipe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spackqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="specs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storeno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uncode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usekind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Goods", namespace = "http://vo.wms.com/xsd", propOrder = {
    "fModifyTime",
    "proportion",
    "barcode",
    "brand",
    "bzq",
    "checkflag",
    "checkmode",
    "clflag",
    "custno",
    "descflag",
    "dosekind",
    "fname",
    "freshCheck",
    "gatherlv",
    "goodsAbc",
    "goodsFlag",
    "goodsHigh",
    "goodsLong",
    "goodsWeight",
    "goodsWidth",
    "incode",
    "indate",
    "intime",
    "isfresh",
    "isweigh",
    "jbdw",
    "lot2",
    "manufacturer",
    "maxrackfloor",
    "midpackqty",
    "minpackqty",
    "minrackfloor",
    "msgid",
    "mulpackage",
    "origin",
    "packbarcode",
    "packqty",
    "packunit",
    "passno",
    "picklv",
    "pname",
    "pym",
    "recipe",
    "spackqty",
    "specs",
    "storeno",
    "type",
    "uncode",
    "unit",
    "usekind"
})
public class Goods {

    @XmlElementRef(name = "FModifyTime", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fModifyTime;
    @XmlElementRef(name = "PROPORTION", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> proportion;
    @XmlElementRef(name = "barcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> barcode;
    @XmlElementRef(name = "brand", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> brand;
    @XmlElementRef(name = "bzq", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bzq;
    @XmlElementRef(name = "checkflag", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> checkflag;
    @XmlElementRef(name = "checkmode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> checkmode;
    @XmlElementRef(name = "clflag", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clflag;
    @XmlElementRef(name = "custno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custno;
    @XmlElementRef(name = "descflag", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descflag;
    @XmlElementRef(name = "dosekind", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dosekind;
    @XmlElementRef(name = "fname", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fname;
    @XmlElementRef(name = "fresh_check", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> freshCheck;
    protected Double gatherlv;
    @XmlElementRef(name = "goods_abc", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> goodsAbc;
    @XmlElementRef(name = "goods_flag", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> goodsFlag;
    @XmlElement(name = "goods_high")
    protected Double goodsHigh;
    @XmlElement(name = "goods_long")
    protected Double goodsLong;
    @XmlElement(name = "goods_weight")
    protected Double goodsWeight;
    @XmlElement(name = "goods_width")
    protected Double goodsWidth;
    @XmlElementRef(name = "incode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incode;
    @XmlElementRef(name = "indate", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> indate;
    @XmlElementRef(name = "intime", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> intime;
    @XmlElementRef(name = "isfresh", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isfresh;
    @XmlElementRef(name = "isweigh", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isweigh;
    @XmlElementRef(name = "jbdw", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jbdw;
    @XmlElementRef(name = "lot2", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lot2;
    @XmlElementRef(name = "manufacturer", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> manufacturer;
    protected Integer maxrackfloor;
    protected Integer midpackqty;
    protected Double minpackqty;
    protected Integer minrackfloor;
    @XmlElementRef(name = "msgid", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> msgid;
    @XmlElementRef(name = "mulpackage", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mulpackage;
    @XmlElementRef(name = "origin", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> origin;
    @XmlElementRef(name = "packbarcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> packbarcode;
    protected Double packqty;
    @XmlElementRef(name = "packunit", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> packunit;
    @XmlElementRef(name = "passno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> passno;
    protected Double picklv;
    @XmlElementRef(name = "pname", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pname;
    @XmlElementRef(name = "pym", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pym;
    @XmlElementRef(name = "recipe", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recipe;
    protected Double spackqty;
    @XmlElementRef(name = "specs", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specs;
    @XmlElementRef(name = "storeno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> storeno;
    @XmlElementRef(name = "type", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> type;
    @XmlElementRef(name = "uncode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uncode;
    @XmlElementRef(name = "unit", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> unit;
    @XmlElementRef(name = "usekind", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usekind;

    /**
     * ��ȡfModifyTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFModifyTime() {
        return fModifyTime;
    }

    /**
     * ����fModifyTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFModifyTime(JAXBElement<String> value) {
        this.fModifyTime = value;
    }

    /**
     * ��ȡproportion���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPROPORTION() {
        return proportion;
    }

    /**
     * ����proportion���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPROPORTION(JAXBElement<String> value) {
        this.proportion = value;
    }

    /**
     * ��ȡbarcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBarcode() {
        return barcode;
    }

    /**
     * ����barcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBarcode(JAXBElement<String> value) {
        this.barcode = value;
    }

    /**
     * ��ȡbrand���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBrand() {
        return brand;
    }

    /**
     * ����brand���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBrand(JAXBElement<String> value) {
        this.brand = value;
    }

    /**
     * ��ȡbzq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBzq() {
        return bzq;
    }

    /**
     * ����bzq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBzq(JAXBElement<String> value) {
        this.bzq = value;
    }

    /**
     * ��ȡcheckflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCheckflag() {
        return checkflag;
    }

    /**
     * ����checkflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCheckflag(JAXBElement<String> value) {
        this.checkflag = value;
    }

    /**
     * ��ȡcheckmode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCheckmode() {
        return checkmode;
    }

    /**
     * ����checkmode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCheckmode(JAXBElement<String> value) {
        this.checkmode = value;
    }

    /**
     * ��ȡclflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClflag() {
        return clflag;
    }

    /**
     * ����clflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClflag(JAXBElement<String> value) {
        this.clflag = value;
    }

    /**
     * ��ȡcustno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustno() {
        return custno;
    }

    /**
     * ����custno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustno(JAXBElement<String> value) {
        this.custno = value;
    }

    /**
     * ��ȡdescflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescflag() {
        return descflag;
    }

    /**
     * ����descflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescflag(JAXBElement<String> value) {
        this.descflag = value;
    }

    /**
     * ��ȡdosekind���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDosekind() {
        return dosekind;
    }

    /**
     * ����dosekind���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDosekind(JAXBElement<String> value) {
        this.dosekind = value;
    }

    /**
     * ��ȡfname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFname() {
        return fname;
    }

    /**
     * ����fname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFname(JAXBElement<String> value) {
        this.fname = value;
    }

    /**
     * ��ȡfreshCheck���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFreshCheck() {
        return freshCheck;
    }

    /**
     * ����freshCheck���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreshCheck(JAXBElement<String> value) {
        this.freshCheck = value;
    }

    /**
     * ��ȡgatherlv���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGatherlv() {
        return gatherlv;
    }

    /**
     * ����gatherlv���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGatherlv(Double value) {
        this.gatherlv = value;
    }

    /**
     * ��ȡgoodsAbc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGoodsAbc() {
        return goodsAbc;
    }

    /**
     * ����goodsAbc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGoodsAbc(JAXBElement<String> value) {
        this.goodsAbc = value;
    }

    /**
     * ��ȡgoodsFlag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGoodsFlag() {
        return goodsFlag;
    }

    /**
     * ����goodsFlag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGoodsFlag(JAXBElement<String> value) {
        this.goodsFlag = value;
    }

    /**
     * ��ȡgoodsHigh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGoodsHigh() {
        return goodsHigh;
    }

    /**
     * ����goodsHigh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGoodsHigh(Double value) {
        this.goodsHigh = value;
    }

    /**
     * ��ȡgoodsLong���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGoodsLong() {
        return goodsLong;
    }

    /**
     * ����goodsLong���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGoodsLong(Double value) {
        this.goodsLong = value;
    }

    /**
     * ��ȡgoodsWeight���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGoodsWeight() {
        return goodsWeight;
    }

    /**
     * ����goodsWeight���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGoodsWeight(Double value) {
        this.goodsWeight = value;
    }

    /**
     * ��ȡgoodsWidth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGoodsWidth() {
        return goodsWidth;
    }

    /**
     * ����goodsWidth���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGoodsWidth(Double value) {
        this.goodsWidth = value;
    }

    /**
     * ��ȡincode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIncode() {
        return incode;
    }

    /**
     * ����incode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncode(JAXBElement<String> value) {
        this.incode = value;
    }

    /**
     * ��ȡindate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIndate() {
        return indate;
    }

    /**
     * ����indate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIndate(JAXBElement<String> value) {
        this.indate = value;
    }

    /**
     * ��ȡintime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIntime() {
        return intime;
    }

    /**
     * ����intime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIntime(JAXBElement<String> value) {
        this.intime = value;
    }

    /**
     * ��ȡisfresh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsfresh() {
        return isfresh;
    }

    /**
     * ����isfresh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsfresh(JAXBElement<String> value) {
        this.isfresh = value;
    }

    /**
     * ��ȡisweigh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsweigh() {
        return isweigh;
    }

    /**
     * ����isweigh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsweigh(JAXBElement<String> value) {
        this.isweigh = value;
    }

    /**
     * ��ȡjbdw���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJbdw() {
        return jbdw;
    }

    /**
     * ����jbdw���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJbdw(JAXBElement<String> value) {
        this.jbdw = value;
    }

    /**
     * ��ȡlot2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLot2() {
        return lot2;
    }

    /**
     * ����lot2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLot2(JAXBElement<String> value) {
        this.lot2 = value;
    }

    /**
     * ��ȡmanufacturer���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getManufacturer() {
        return manufacturer;
    }

    /**
     * ����manufacturer���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setManufacturer(JAXBElement<String> value) {
        this.manufacturer = value;
    }

    /**
     * ��ȡmaxrackfloor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxrackfloor() {
        return maxrackfloor;
    }

    /**
     * ����maxrackfloor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxrackfloor(Integer value) {
        this.maxrackfloor = value;
    }

    /**
     * ��ȡmidpackqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMidpackqty() {
        return midpackqty;
    }

    /**
     * ����midpackqty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMidpackqty(Integer value) {
        this.midpackqty = value;
    }

    /**
     * ��ȡminpackqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinpackqty() {
        return minpackqty;
    }

    /**
     * ����minpackqty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinpackqty(Double value) {
        this.minpackqty = value;
    }

    /**
     * ��ȡminrackfloor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinrackfloor() {
        return minrackfloor;
    }

    /**
     * ����minrackfloor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinrackfloor(Integer value) {
        this.minrackfloor = value;
    }

    /**
     * ��ȡmsgid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMsgid() {
        return msgid;
    }

    /**
     * ����msgid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMsgid(JAXBElement<String> value) {
        this.msgid = value;
    }

    /**
     * ��ȡmulpackage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMulpackage() {
        return mulpackage;
    }

    /**
     * ����mulpackage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMulpackage(JAXBElement<String> value) {
        this.mulpackage = value;
    }

    /**
     * ��ȡorigin���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrigin() {
        return origin;
    }

    /**
     * ����origin���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrigin(JAXBElement<String> value) {
        this.origin = value;
    }

    /**
     * ��ȡpackbarcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPackbarcode() {
        return packbarcode;
    }

    /**
     * ����packbarcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPackbarcode(JAXBElement<String> value) {
        this.packbarcode = value;
    }

    /**
     * ��ȡpackqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPackqty() {
        return packqty;
    }

    /**
     * ����packqty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPackqty(Double value) {
        this.packqty = value;
    }

    /**
     * ��ȡpackunit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPackunit() {
        return packunit;
    }

    /**
     * ����packunit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPackunit(JAXBElement<String> value) {
        this.packunit = value;
    }

    /**
     * ��ȡpassno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassno() {
        return passno;
    }

    /**
     * ����passno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassno(JAXBElement<String> value) {
        this.passno = value;
    }

    /**
     * ��ȡpicklv���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPicklv() {
        return picklv;
    }

    /**
     * ����picklv���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPicklv(Double value) {
        this.picklv = value;
    }

    /**
     * ��ȡpname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPname() {
        return pname;
    }

    /**
     * ����pname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPname(JAXBElement<String> value) {
        this.pname = value;
    }

    /**
     * ��ȡpym���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPym() {
        return pym;
    }

    /**
     * ����pym���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPym(JAXBElement<String> value) {
        this.pym = value;
    }

    /**
     * ��ȡrecipe���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecipe() {
        return recipe;
    }

    /**
     * ����recipe���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecipe(JAXBElement<String> value) {
        this.recipe = value;
    }

    /**
     * ��ȡspackqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSpackqty() {
        return spackqty;
    }

    /**
     * ����spackqty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSpackqty(Double value) {
        this.spackqty = value;
    }

    /**
     * ��ȡspecs���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecs() {
        return specs;
    }

    /**
     * ����specs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecs(JAXBElement<String> value) {
        this.specs = value;
    }

    /**
     * ��ȡstoreno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStoreno() {
        return storeno;
    }

    /**
     * ����storeno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStoreno(JAXBElement<String> value) {
        this.storeno = value;
    }

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setType(JAXBElement<String> value) {
        this.type = value;
    }

    /**
     * ��ȡuncode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUncode() {
        return uncode;
    }

    /**
     * ����uncode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUncode(JAXBElement<String> value) {
        this.uncode = value;
    }

    /**
     * ��ȡunit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnit() {
        return unit;
    }

    /**
     * ����unit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnit(JAXBElement<String> value) {
        this.unit = value;
    }

    /**
     * ��ȡusekind���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsekind() {
        return usekind;
    }

    /**
     * ����usekind���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsekind(JAXBElement<String> value) {
        this.usekind = value;
    }

}
