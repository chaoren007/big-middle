
package com.wms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Putorderdet complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Putorderdet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ERPID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PSCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bitem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cgeneralbid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custprd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gdsproperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hprc" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="incode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jbdw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mocode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="packs" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="packunit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pincode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="sqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="stat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storeno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tld" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uncode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zphzstat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Putorderdet", namespace = "http://vo.wms.com/xsd", propOrder = {
    "erpid",
    "pscode",
    "psid",
    "barcode",
    "bitem",
    "cgeneralbid",
    "custno",
    "custprd",
    "fname",
    "gdsproperty",
    "hprc",
    "incode",
    "jbdw",
    "jobno",
    "mocode",
    "modid",
    "orderno",
    "packqty",
    "packs",
    "packunit",
    "pincode",
    "qty",
    "sqty",
    "stat",
    "storcode",
    "storeno",
    "tld",
    "uncode",
    "unit",
    "zphzstat"
})
public class Putorderdet {

    @XmlElementRef(name = "ERPID", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> erpid;
    @XmlElementRef(name = "PSCODE", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pscode;
    @XmlElementRef(name = "PSID", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> psid;
    @XmlElementRef(name = "barcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> barcode;
    @XmlElementRef(name = "bitem", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> bitem;
    @XmlElementRef(name = "cgeneralbid", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cgeneralbid;
    @XmlElementRef(name = "custno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custno;
    @XmlElementRef(name = "custprd", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custprd;
    @XmlElementRef(name = "fname", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fname;
    @XmlElementRef(name = "gdsproperty", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gdsproperty;
    protected Double hprc;
    @XmlElementRef(name = "incode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incode;
    @XmlElementRef(name = "jbdw", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jbdw;
    @XmlElementRef(name = "jobno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jobno;
    @XmlElementRef(name = "mocode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mocode;
    @XmlElementRef(name = "modid", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> modid;
    @XmlElementRef(name = "orderno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orderno;
    protected Double packqty;
    protected Double packs;
    @XmlElementRef(name = "packunit", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> packunit;
    @XmlElementRef(name = "pincode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pincode;
    protected Double qty;
    protected Double sqty;
    @XmlElementRef(name = "stat", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stat;
    @XmlElementRef(name = "storcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> storcode;
    @XmlElementRef(name = "storeno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> storeno;
    @XmlElementRef(name = "tld", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tld;
    @XmlElementRef(name = "uncode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uncode;
    @XmlElementRef(name = "unit", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> unit;
    @XmlElementRef(name = "zphzstat", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> zphzstat;

    /**
     * ��ȡerpid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getERPID() {
        return erpid;
    }

    /**
     * ����erpid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setERPID(JAXBElement<String> value) {
        this.erpid = value;
    }

    /**
     * ��ȡpscode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPSCODE() {
        return pscode;
    }

    /**
     * ����pscode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPSCODE(JAXBElement<String> value) {
        this.pscode = value;
    }

    /**
     * ��ȡpsid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPSID() {
        return psid;
    }

    /**
     * ����psid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPSID(JAXBElement<String> value) {
        this.psid = value;
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
     * ��ȡbitem���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBitem() {
        return bitem;
    }

    /**
     * ����bitem���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBitem(JAXBElement<String> value) {
        this.bitem = value;
    }

    /**
     * ��ȡcgeneralbid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCgeneralbid() {
        return cgeneralbid;
    }

    /**
     * ����cgeneralbid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCgeneralbid(JAXBElement<String> value) {
        this.cgeneralbid = value;
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
     * ��ȡcustprd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustprd() {
        return custprd;
    }

    /**
     * ����custprd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustprd(JAXBElement<String> value) {
        this.custprd = value;
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
     * ��ȡgdsproperty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGdsproperty() {
        return gdsproperty;
    }

    /**
     * ����gdsproperty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGdsproperty(JAXBElement<String> value) {
        this.gdsproperty = value;
    }

    /**
     * ��ȡhprc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHprc() {
        return hprc;
    }

    /**
     * ����hprc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHprc(Double value) {
        this.hprc = value;
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
     * ��ȡjobno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJobno() {
        return jobno;
    }

    /**
     * ����jobno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJobno(JAXBElement<String> value) {
        this.jobno = value;
    }

    /**
     * ��ȡmocode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMocode() {
        return mocode;
    }

    /**
     * ����mocode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMocode(JAXBElement<String> value) {
        this.mocode = value;
    }

    /**
     * ��ȡmodid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getModid() {
        return modid;
    }

    /**
     * ����modid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setModid(JAXBElement<String> value) {
        this.modid = value;
    }

    /**
     * ��ȡorderno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderno() {
        return orderno;
    }

    /**
     * ����orderno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderno(JAXBElement<String> value) {
        this.orderno = value;
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
     * ��ȡpacks���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPacks() {
        return packs;
    }

    /**
     * ����packs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPacks(Double value) {
        this.packs = value;
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
     * ��ȡpincode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPincode() {
        return pincode;
    }

    /**
     * ����pincode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPincode(JAXBElement<String> value) {
        this.pincode = value;
    }

    /**
     * ��ȡqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getQty() {
        return qty;
    }

    /**
     * ����qty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setQty(Double value) {
        this.qty = value;
    }

    /**
     * ��ȡsqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSqty() {
        return sqty;
    }

    /**
     * ����sqty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSqty(Double value) {
        this.sqty = value;
    }

    /**
     * ��ȡstat���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStat() {
        return stat;
    }

    /**
     * ����stat���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStat(JAXBElement<String> value) {
        this.stat = value;
    }

    /**
     * ��ȡstorcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStorcode() {
        return storcode;
    }

    /**
     * ����storcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStorcode(JAXBElement<String> value) {
        this.storcode = value;
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
     * ��ȡtld���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTld() {
        return tld;
    }

    /**
     * ����tld���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTld(JAXBElement<String> value) {
        this.tld = value;
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
     * ��ȡzphzstat���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getZphzstat() {
        return zphzstat;
    }

    /**
     * ����zphzstat���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setZphzstat(JAXBElement<String> value) {
        this.zphzstat = value;
    }

}
