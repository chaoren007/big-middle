
package com.wms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Dept complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Dept">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="custno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dept", namespace = "http://vo.wms.com/xsd", propOrder = {
    "custno",
    "deptname",
    "deptno",
    "memo"
})
public class Dept {

    @XmlElementRef(name = "custno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> custno;
    @XmlElementRef(name = "deptname", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deptname;
    @XmlElementRef(name = "deptno", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deptno;
    @XmlElementRef(name = "memo", namespace = "http://vo.wms.com/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> memo;

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
     * ��ȡdeptname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeptname() {
        return deptname;
    }

    /**
     * ����deptname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeptname(JAXBElement<String> value) {
        this.deptname = value;
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
     * ��ȡmemo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMemo() {
        return memo;
    }

    /**
     * ����memo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMemo(JAXBElement<String> value) {
        this.memo = value;
    }

}
