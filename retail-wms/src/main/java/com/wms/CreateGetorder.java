
package com.wms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="list" type="{http://vo.wms.com/xsd}Getorder" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="list2" type="{http://vo.wms.com/xsd}Getorderdet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="list3" type="{http://vo.wms.com/xsd}Getorderdet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "list",
    "list2",
    "list3"
})
@XmlRootElement(name = "CreateGetorder")
public class CreateGetorder {

    @XmlElement(nillable = true)
    protected List<Getorder> list;
    @XmlElement(nillable = true)
    protected List<Getorderdet> list2;
    @XmlElement(nillable = true)
    protected List<Getorderdet> list3;

    /**
     * Gets the value of the list property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the list property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Getorder }
     * 
     * 
     */
    public List<Getorder> getList() {
        if (list == null) {
            list = new ArrayList<Getorder>();
        }
        return this.list;
    }

    /**
     * Gets the value of the list2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the list2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getList2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Getorderdet }
     * 
     * 
     */
    public List<Getorderdet> getList2() {
        if (list2 == null) {
            list2 = new ArrayList<Getorderdet>();
        }
        return this.list2;
    }

    /**
     * Gets the value of the list3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the list3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getList3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Getorderdet }
     * 
     * 
     */
    public List<Getorderdet> getList3() {
        if (list3 == null) {
            list3 = new ArrayList<Getorderdet>();
        }
        return this.list3;
    }

}
