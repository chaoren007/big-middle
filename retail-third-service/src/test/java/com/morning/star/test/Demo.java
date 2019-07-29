package com.morning.star.test;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.Main;
import com.morning.star.retail.facade.KingdeeAddGoodsFacade;
import com.morning.star.retail.facade.impl.KingdeeAddGoodsFacadeImpl;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import com.morning.star.retail.facade.BusOpcFacade;
import com.morning.star.retail.facade.KingdeeTaxFacade;
import com.morning.star.retail.facade.dto.BusOpcDTO;
import com.morning.star.retail.facade.dto.BusProductDTO;
import com.morning.star.retail.facade.dto.BusResultDTO;
import com.morning.star.retail.facade.dto.TaxKdDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2018/11/13 18:28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class Demo {
    @Autowired
    private KingdeeTaxFacade invokeHelper;
    @Autowired
    private BusOpcFacade busOpcFacade;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private KingdeeAddGoodsFacadeImpl kingdeeAddGoodsFacade;

    @Test
    public void Test() {
        TaxKdDTO tax = new TaxKdDTO("测试税种", 2, "2018-12-26 00:00:00", "2018-12-27 00:00:00", "1");
        invokeHelper.addTaxRate(tax);
    }

    @Test
    public void Test1() {
        BusOpcDTO dto = new BusOpcDTO();
        dto.setOpc("GS00000020");
        dto.setOpcName("中台测试运营点");
        dto.setSupplierEnterPhone("17371341633");
        dto.setAgentEnterPhone("17371341633");
        dto.setCreateTime(new Date());
        BusResultDTO result = busOpcFacade.add(dto);
        System.out.println("---------------------------" + JSON.toJSONString(result));
    }

    @Test
    public void Test2() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("opc", "GS00000020");
        map.add("opcName", "中台测试运营点");
        map.add("supplierEnterPhone", "17371341633");
        map.add("agentEnterPhone", "17371341633");
        map.add("createTime", date);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://test-pt-ms.niwoning.com/pt-ms/api/opc/createOpc", request, String.class);
        String body = response.getBody();
        System.out.println("===============================" + body);
    }

    @Test
    public void addProduct() {
        BusProductDTO dto = new BusProductDTO();
        dto.setCreatedTime("2019-01-10 10:47:39");
        dto.setOpc("GS00000020");
        dto.setpCode("1001010003");
        dto.setpName("系列瑞士进口手表男士 商务男表全自动机械表带日历");
        dto.setSupplierName("15");
        dto.setProductType(1);
        dto.setpCategId("100101");
        dto.setpCategName("苹果");
        dto.setIsFarm(0);
        dto.setpDes("");
        dto.setCreateor("GS00000020");
        List<BusProductDTO.ProductList> productList = new ArrayList<>();
        BusProductDTO.ProductList product = new BusProductDTO.ProductList();

        List<BusProductDTO.ProductList.ProductParamListBean> productParamList = new ArrayList<>();
        BusProductDTO.ProductList.ProductParamListBean bean1 = new BusProductDTO.ProductList.ProductParamListBean();
        BusProductDTO.ProductList.ProductParamListBean bean2 = new BusProductDTO.ProductList.ProductParamListBean();
        bean1.setParamName("颜色");
        bean1.setParamValue("红色");
        bean2.setParamName("型号");
        bean2.setParamValue("大");
        productParamList.add(bean1);
        productParamList.add(bean2);

        List<BusProductDTO.ProductList.PImgDessBean> pImgDessBeanList = new ArrayList<>();
        BusProductDTO.ProductList.PImgDessBean pImgDessBean = new BusProductDTO.ProductList.PImgDessBean();
        pImgDessBean.setId(0);
        pImgDessBean.setImgUrl("https://img.allpyra.com/71bf30a2-7d59-45c9-b278-d402693d2af8.jpg");
        pImgDessBeanList.add(pImgDessBean);

        product.setpCode("1001010003");
        product.setpImgDes("https://img.allpyra.com/71bf30a2-7d59-45c9-b278-d402693d2af8.jpg,");
        product.setpImgIndex("https://img.allpyra.com/1cdf4f4f-a5e6-4f81-b05f-d964cc5bad59.jpg,");
        product.setpImgs("https://img.allpyra.com/1cdf4f4f-a5e6-4f81-b05f-d964cc5bad59.jpg,");
        product.setpName("系列瑞士进口手表男士 商务男表全自动机械表带日历");
        product.setpImgDess(pImgDessBeanList);
        product.setProductParamList(productParamList);

        productList.add(product);

        dto.setProductList(productList);
        dto.setProductParamList("[{\\\"paramName\\\":\\\"颜色\\\",\\\"paramValue\\\":\\\"红色\\\"},{\\\"paramName\\\":\\\"型号\\\",\\\"paramValue\\\":\\\"大\\\"}]");
        String s = restTemplate.postForObject("https://test-pt-ms.niwoning.com/pt-ms/api/product/createProduct", dto, String.class);
        System.out.println(s);

    }

    @Test
    public void test2(){
    }





}

  
  
   