
package com.wms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Getorderdet complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Getorderdet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ERPID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apptype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="batchid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="batchno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blargess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="closeflag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crowno" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="custno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custprd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iamt" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="incode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inprc" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="instore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jbdw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ordertype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outstore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="packs" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="packunit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="producedate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="rdname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sqty" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="supplyno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="whid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Getorderdet", namespace = "http://vo.wms.com/xsd", propOrder = {
    "erpid",
    "msgid",
    "apptype",
    "barcode",
    "batchid",
    "batchno",
    "blargess",
    "closeflag",
    "crowno",
    "custno",
    "customer",
    "custprd",
    "fname",
    "iamt",
    "incode",
    "inprc",
    "instore",
    "invcode",
    "jbdw",
    "lastdate",
    "ordertype",
    "outstore",
    "packqty",
    "packs",
    "packunit",
    "producedate",
    "purcode",
    "qty",
    "rdname",
    "specs",
    "sqty",
    "supplyno",
    "unit",
    "whid"
})
public class Getorderdet {

    @XmlElementRef(name = "ERPID", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> erpid;
    @XmlElementRef(name = "MSGID", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> msgid;
    @XmlElementRef(name = "apptype", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> apptype;
    @XmlElementRef(name = "barcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> barcode;
    @XmlElementRef(name = "batchid", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> batchid;
    @XmlElementRef(name = "batchno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> batchno;
    @XmlElementRef(name = "blargess", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> blargess;
    @XmlElementRef(name = "closeflag", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> closeflag;
    protected Integer crowno;
    @XmlElementRef(name = "custno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custno;
    @XmlElementRef(name = "customer", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customer;
    @XmlElementRef(name = "custprd", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custprd;
    @XmlElementRef(name = "fname", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fname;
    protected Double iamt;
    @XmlElementRef(name = "incode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incode;
    protected Double inprc;
    @XmlElementRef(name = "instore", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> instore;
    @XmlElementRef(name = "invcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invcode;
    @XmlElementRef(name = "jbdw", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jbdw;
    @XmlElementRef(name = "lastdate", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastdate;
    @XmlElementRef(name = "ordertype", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ordertype;
    @XmlElementRef(name = "outstore", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> outstore;
    protected Double packqty;
    protected Double packs;
    @XmlElementRef(name = "packunit", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> packunit;
    @XmlElementRef(name = "producedate", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> producedate;
    @XmlElementRef(name = "purcode", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purcode;
    protected Double qty;
    @XmlElementRef(name = "rdname", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rdname;
    @XmlElementRef(name = "specs", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specs;
    protected Double sqty;
    @XmlElementRef(name = "supplyno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> supplyno;
    @XmlElementRef(name = "unit", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> unit;
    @XmlElementRef(name = "whid", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> whid;

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
     * ��ȡmsgid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMSGID() {
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
    public void setMSGID(JAXBElement<String> value) {
        this.msgid = value;
    }

    /**
     * ��ȡapptype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApptype() {
        return apptype;
    }

    /**
     * ����apptype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApptype(JAXBElement<String> value) {
        this.apptype = value;
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
     * ��ȡbatchid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBatchid() {
        return batchid;
    }

    /**
     * ����batchid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBatchid(JAXBElement<String> value) {
        this.batchid = value;
    }

    /**
     * ��ȡbatchno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBatchno() {
        return batchno;
    }

    /**
     * ����batchno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBatchno(JAXBElement<String> value) {
        this.batchno = value;
    }

    /**
     * ��ȡblargess���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBlargess() {
        return blargess;
    }

    /**
     * ����blargess���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBlargess(JAXBElement<String> value) {
        this.blargess = value;
    }

    /**
     * ��ȡcloseflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCloseflag() {
        return closeflag;
    }

    /**
     * ����closeflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCloseflag(JAXBElement<String> value) {
        this.closeflag = value;
    }

    /**
     * ��ȡcrowno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCrowno() {
        return crowno;
    }

    /**
     * ����crowno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCrowno(Integer value) {
        this.crowno = value;
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
     * ��ȡcustomer���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomer() {
        return customer;
    }

    /**
     * ����customer���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomer(JAXBElement<String> value) {
        this.customer = value;
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
     * ��ȡiamt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIamt() {
        return iamt;
    }

    /**
     * ����iamt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIamt(Double value) {
        this.iamt = value;
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
     * ��ȡinprc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInprc() {
        return inprc;
    }

    /**
     * ����inprc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInprc(Double value) {
        this.inprc = value;
    }

    /**
     * ��ȡinstore���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInstore() {
        return instore;
    }

    /**
     * ����instore���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInstore(JAXBElement<String> value) {
        this.instore = value;
    }

    /**
     * ��ȡinvcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvcode() {
        return invcode;
    }

    /**
     * ����invcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvcode(JAXBElement<String> value) {
        this.invcode = value;
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
     * ��ȡlastdate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastdate() {
        return lastdate;
    }

    /**
     * ����lastdate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastdate(JAXBElement<String> value) {
        this.lastdate = value;
    }

    /**
     * ��ȡordertype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrdertype() {
        return ordertype;
    }

    /**
     * ����ordertype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrdertype(JAXBElement<String> value) {
        this.ordertype = value;
    }

    /**
     * ��ȡoutstore���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOutstore() {
        return outstore;
    }

    /**
     * ����outstore���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOutstore(JAXBElement<String> value) {
        this.outstore = value;
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
     * ��ȡproducedate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProducedate() {
        return producedate;
    }

    /**
     * ����producedate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProducedate(JAXBElement<String> value) {
        this.producedate = value;
    }

    /**
     * ��ȡpurcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurcode() {
        return purcode;
    }

    /**
     * ����purcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurcode(JAXBElement<String> value) {
        this.purcode = value;
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
     * ��ȡrdname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRdname() {
        return rdname;
    }

    /**
     * ����rdname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRdname(JAXBElement<String> value) {
        this.rdname = value;
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
     * ��ȡsupplyno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSupplyno() {
        return supplyno;
    }

    /**
     * ����supplyno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSupplyno(JAXBElement<String> value) {
        this.supplyno = value;
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
     * ��ȡwhid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWhid() {
        return whid;
    }

    /**
     * ����whid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWhid(JAXBElement<String> value) {
        this.whid = value;
    }

}
