
package com.wms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Partner complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Partner">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_linman" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_lxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_order" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_psid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_pym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partner_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storeno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Partner", namespace = "http://vo.wms.com/xsd", propOrder = {
    "age",
    "birthday",
    "custno",
    "deptno",
    "partnerAddress",
    "partnerGroup",
    "partnerLinman",
    "partnerLxr",
    "partnerName",
    "partnerNo",
    "partnerOrder",
    "partnerPsid",
    "partnerPym",
    "partnerTel",
    "partnerType",
    "sex",
    "storeno"
})
public class Partner {

    @XmlElementRef(name = "age", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> age;
    @XmlElementRef(name = "birthday", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> birthday;
    @XmlElementRef(name = "custno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custno;
    @XmlElementRef(name = "deptno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deptno;
    @XmlElementRef(name = "partner_address", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerAddress;
    @XmlElementRef(name = "partner_group", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerGroup;
    @XmlElementRef(name = "partner_linman", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerLinman;
    @XmlElementRef(name = "partner_lxr", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerLxr;
    @XmlElementRef(name = "partner_name", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerName;
    @XmlElementRef(name = "partner_no", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerNo;
    @XmlElementRef(name = "partner_order", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerOrder;
    @XmlElementRef(name = "partner_psid", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerPsid;
    @XmlElementRef(name = "partner_pym", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerPym;
    @XmlElementRef(name = "partner_tel", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerTel;
    @XmlElementRef(name = "partner_type", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> partnerType;
    @XmlElementRef(name = "sex", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sex;
    @XmlElementRef(name = "storeno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> storeno;

    /**
     * ��ȡage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAge() {
        return age;
    }

    /**
     * ����age���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAge(JAXBElement<String> value) {
        this.age = value;
    }

    /**
     * ��ȡbirthday���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBirthday() {
        return birthday;
    }

    /**
     * ����birthday���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBirthday(JAXBElement<String> value) {
        this.birthday = value;
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
     * ��ȡdeptno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeptno() {
        return deptno;
    }

    /**
     * ����deptno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeptno(JAXBElement<String> value) {
        this.deptno = value;
    }

    /**
     * ��ȡpartnerAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerAddress() {
        return partnerAddress;
    }

    /**
     * ����partnerAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerAddress(JAXBElement<String> value) {
        this.partnerAddress = value;
    }

    /**
     * ��ȡpartnerGroup���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerGroup() {
        return partnerGroup;
    }

    /**
     * ����partnerGroup���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerGroup(JAXBElement<String> value) {
        this.partnerGroup = value;
    }

    /**
     * ��ȡpartnerLinman���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerLinman() {
        return partnerLinman;
    }

    /**
     * ����partnerLinman���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerLinman(JAXBElement<String> value) {
        this.partnerLinman = value;
    }

    /**
     * ��ȡpartnerLxr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerLxr() {
        return partnerLxr;
    }

    /**
     * ����partnerLxr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerLxr(JAXBElement<String> value) {
        this.partnerLxr = value;
    }

    /**
     * ��ȡpartnerName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerName() {
        return partnerName;
    }

    /**
     * ����partnerName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerName(JAXBElement<String> value) {
        this.partnerName = value;
    }

    /**
     * ��ȡpartnerNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerNo() {
        return partnerNo;
    }

    /**
     * ����partnerNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerNo(JAXBElement<String> value) {
        this.partnerNo = value;
    }

    /**
     * ��ȡpartnerOrder���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerOrder() {
        return partnerOrder;
    }

    /**
     * ����partnerOrder���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerOrder(JAXBElement<String> value) {
        this.partnerOrder = value;
    }

    /**
     * ��ȡpartnerPsid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerPsid() {
        return partnerPsid;
    }

    /**
     * ����partnerPsid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerPsid(JAXBElement<String> value) {
        this.partnerPsid = value;
    }

    /**
     * ��ȡpartnerPym���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerPym() {
        return partnerPym;
    }

    /**
     * ����partnerPym���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerPym(JAXBElement<String> value) {
        this.partnerPym = value;
    }

    /**
     * ��ȡpartnerTel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerTel() {
        return partnerTel;
    }

    /**
     * ����partnerTel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerTel(JAXBElement<String> value) {
        this.partnerTel = value;
    }

    /**
     * ��ȡpartnerType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPartnerType() {
        return partnerType;
    }

    /**
     * ����partnerType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPartnerType(JAXBElement<String> value) {
        this.partnerType = value;
    }

    /**
     * ��ȡsex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSex() {
        return sex;
    }

    /**
     * ����sex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSex(JAXBElement<String> value) {
        this.sex = value;
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

}
