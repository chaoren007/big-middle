
package com.wms;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WMSPortType", targetNamespace = "http://service.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WMSPortType {


    /**
     * 
     * @param list2
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateMove", action = "urn:CreateMove")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateMove", targetNamespace = "http://service.com", className = "com.wms.CreateMove")
    @ResponseWrapper(localName = "CreateMoveResponse", targetNamespace = "http://service.com", className = "com.wms.CreateMoveResponse")
    public Remsg createMove(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Getorder> list,
        @WebParam(name = "list2", targetNamespace = "http://service.com")
        List<Getorderdet> list2);

    /**
     * 
     * @param list2
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreatePutorder", action = "urn:CreatePutorder")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreatePutorder", targetNamespace = "http://service.com", className = "com.wms.CreatePutorder")
    @ResponseWrapper(localName = "CreatePutorderResponse", targetNamespace = "http://service.com", className = "com.wms.CreatePutorderResponse")
    public Remsg createPutorder(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Putorder> list,
        @WebParam(name = "list2", targetNamespace = "http://service.com")
        List<Putorderdet> list2);

    /**
     * 
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateCustomer", action = "urn:CreateCustomer")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateCustomer", targetNamespace = "http://service.com", className = "com.wms.CreateCustomer")
    @ResponseWrapper(localName = "CreateCustomerResponse", targetNamespace = "http://service.com", className = "com.wms.CreateCustomerResponse")
    public Remsg createCustomer(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Customer> list);

    /**
     * 
     * @param list2
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateDTorder", action = "urn:CreateDTorder")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateDTorder", targetNamespace = "http://service.com", className = "com.wms.CreateDTorder")
    @ResponseWrapper(localName = "CreateDTorderResponse", targetNamespace = "http://service.com", className = "com.wms.CreateDTorderResponse")
    public Remsg createDTorder(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Getorder> list,
        @WebParam(name = "list2", targetNamespace = "http://service.com")
        List<Getorderdet> list2);

    /**
     * 
     * @param list2
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateGoods", action = "urn:CreateGoods")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateGoods", targetNamespace = "http://service.com", className = "com.wms.CreateGoods")
    @ResponseWrapper(localName = "CreateGoodsResponse", targetNamespace = "http://service.com", className = "com.wms.CreateGoodsResponse")
    public Remsg createGoods(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Goods> list,
        @WebParam(name = "list2", targetNamespace = "http://service.com")
        List<Goods> list2);

    /**
     * 
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateStore", action = "urn:CreateStore")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateStore", targetNamespace = "http://service.com", className = "com.wms.CreateStore")
    @ResponseWrapper(localName = "CreateStoreResponse", targetNamespace = "http://service.com", className = "com.wms.CreateStoreResponse")
    public Remsg createStore(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Store> list);

    /**
     * 
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateDept", action = "urn:CreateDept")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateDept", targetNamespace = "http://service.com", className = "com.wms.CreateDept")
    @ResponseWrapper(localName = "CreateDeptResponse", targetNamespace = "http://service.com", className = "com.wms.CreateDeptResponse")
    public Remsg createDept(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Dept> list);

    /**
     * 
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreatePartner", action = "urn:CreatePartner")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreatePartner", targetNamespace = "http://service.com", className = "com.wms.CreatePartner")
    @ResponseWrapper(localName = "CreatePartnerResponse", targetNamespace = "http://service.com", className = "com.wms.CreatePartnerResponse")
    public Remsg createPartner(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Partner> list);

    /**
     * 
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateGoodsType", action = "urn:CreateGoodsType")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateGoodsType", targetNamespace = "http://service.com", className = "com.wms.CreateGoodsType")
    @ResponseWrapper(localName = "CreateGoodsTypeResponse", targetNamespace = "http://service.com", className = "com.wms.CreateGoodsTypeResponse")
    public Remsg createGoodsType(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<GoodsType> list);

    /**
     * 
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "Updatedocmx", action = "urn:Updatedocmx")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "Updatedocmx", targetNamespace = "http://service.com", className = "com.wms.Updatedocmx")
    @ResponseWrapper(localName = "UpdatedocmxResponse", targetNamespace = "http://service.com", className = "com.wms.UpdatedocmxResponse")
    public Remsg updatedocmx(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Getorderdet> list);

    /**
     * 
     * @param list3
     * @param list2
     * @param list
     * @return
     *     returns com.wms.Remsg
     */
    @WebMethod(operationName = "CreateGetorder", action = "urn:CreateGetorder")
    @WebResult(targetNamespace = "http://service.com")
    @RequestWrapper(localName = "CreateGetorder", targetNamespace = "http://service.com", className = "com.wms.CreateGetorder")
    @ResponseWrapper(localName = "CreateGetorderResponse", targetNamespace = "http://service.com", className = "com.wms.CreateGetorderResponse")
    public Remsg createGetorder(
        @WebParam(name = "list", targetNamespace = "http://service.com")
        List<Getorder> list,
        @WebParam(name = "list2", targetNamespace = "http://service.com")
        List<Getorderdet> list2,
        @WebParam(name = "list3", targetNamespace = "http://service.com")
        List<Getorderdet> list3);

}
