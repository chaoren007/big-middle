package com.morning.star.retail.group.device;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.morning.star.retail.Main;
import com.morning.star.retail.application.SupBusItemApplication;
import com.morning.star.retail.dto.BindDeviceDTO;
import com.morning.star.retail.facade.DeviceFacade;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.helper.BusItemHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kimhuhg
 * @create_time 2018/7/26 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class DeviceFacadeTest {

    @Autowired
    private DeviceFacade deviceFacade;

    @Autowired
    private BusItemHelper busItemHelper;

    @Autowired
    private SupBusItemApplication supBusItemApplication;

    private Gson gson = new Gson();

    @Test
    public void getDevice() {
        BindDeviceDTO bindDeviceDTO = new BindDeviceDTO();
//        bindDeviceDTO.setStoreCode("");
        bindDeviceDTO.setDeviceId("T117181700661");
        bindDeviceDTO.setDeviceVersion("12");
        bindDeviceDTO.setSoftwareVersion("12");
        bindDeviceDTO.setSecretKey("2yo491psgljp");

        deviceFacade.bindDevice(bindDeviceDTO);
        System.out.println("测试信息:" + gson.toJson(deviceFacade.getDevice("T10316C100215")));
    }

    @Test
    public void test1() {
        GoodsSupplyDTO supInfo = busItemHelper.getSupInfo("PC190314140208001003");
        System.out.println("+++++++++++++++++:" + JSON.toJSONString(supInfo));
    }

    @Test
    public void test2() {
        supBusItemApplication.insertSupBusItem();
    }
//
//	@Test
//	public void checkGetDevice() {
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.checkGetDevice("T10316C100215")));
//	}
//
//	@Test
//	public void pageDeviceForGod() {
//		QueryPageDeviceDTO queryPageDeviceDTO = new QueryPageDeviceDTO();
//		queryPageDeviceDTO.setDeviceId("T10316C100215");
//
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.pageDeviceForGod(queryPageDeviceDTO)));
//	}
//
//	@Test
//	public void listDevice() {
//		QueryPageDeviceDTO queryPageDeviceDTO = new QueryPageDeviceDTO();
//		queryPageDeviceDTO.setDeviceId("T10316C100215");
//
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.listDevice(queryPageDeviceDTO)));
//	}
//
//	@Test
//	public void addKey() {
//		QueryDeviceDTO queryDeviceDTO = new QueryDeviceDTO();
//		queryDeviceDTO.setGroupCode("test123");
//		queryDeviceDTO.setGroupName("");
//		queryDeviceDTO.setCompanyCode("");
//		queryDeviceDTO.setCompanyName("");
//		queryDeviceDTO.setStoreCode("");
//		queryDeviceDTO.setDeviceId("");
//		queryDeviceDTO.setDeviceVersion("");
//		queryDeviceDTO.setSoftwareVersion("");
//		queryDeviceDTO.setKey("");
//		queryDeviceDTO.setStatus(0);
//		queryDeviceDTO.setActivityTime(new Date());
//		queryDeviceDTO.setLastLoginTime(new Date());
//		queryDeviceDTO.setLastRegTime(new Date());
//		queryDeviceDTO.setLastHeartbeatTime(new Date());
//		queryDeviceDTO.setExpireDate(new Date());
//		queryDeviceDTO.setCreateTime(new Date());
//		queryDeviceDTO.setOperatorId(0);
//		queryDeviceDTO.setOperatorName("");
//		queryDeviceDTO.setRemark("");
//
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.addKey(queryDeviceDTO)));
//	}
//
//	@Test
//	public void modifyExpireDate() {
//		QueryDeviceDTO queryDeviceDTO = new QueryDeviceDTO();
//		queryDeviceDTO.setId(260);
//		queryDeviceDTO.setGroupCode("test123");
//		queryDeviceDTO.setGroupName("");
//		queryDeviceDTO.setCompanyCode("test123");
//		queryDeviceDTO.setCompanyName("");
//		queryDeviceDTO.setStoreCode("");
//		queryDeviceDTO.setDeviceId("w");
//		queryDeviceDTO.setDeviceVersion("");
//		queryDeviceDTO.setSoftwareVersion("");
//		queryDeviceDTO.setKey("rg2nl2akj7k0");
//		queryDeviceDTO.setStatus(0);
//		queryDeviceDTO.setActivityTime(new Date());
//		queryDeviceDTO.setLastLoginTime(new Date());
//		queryDeviceDTO.setLastRegTime(new Date());
//		queryDeviceDTO.setLastHeartbeatTime(new Date());
//		queryDeviceDTO.setExpireDate(new Date());
//		queryDeviceDTO.setCreateTime(new Date());
//		queryDeviceDTO.setOperatorId(0);
//		queryDeviceDTO.setOperatorName("");
//		queryDeviceDTO.setRemark("");
//
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.modifyExpireDate(queryDeviceDTO)));
//	}
//
//	@Test
//	public void initKey() {
//		QueryDeviceDTO queryDeviceDTO = new QueryDeviceDTO();
//		queryDeviceDTO.setId(260);
//		queryDeviceDTO.setGroupCode("test123");
//		queryDeviceDTO.setGroupName("");
//		queryDeviceDTO.setCompanyCode("test123");
//		queryDeviceDTO.setCompanyName("");
//		queryDeviceDTO.setStoreCode("");
//		queryDeviceDTO.setDeviceId("w");
//		queryDeviceDTO.setDeviceVersion("");
//		queryDeviceDTO.setSoftwareVersion("");
//		queryDeviceDTO.setKey("lbhpscjmlmdj");
//		queryDeviceDTO.setStatus(0);
//		queryDeviceDTO.setActivityTime(new Date());
//		queryDeviceDTO.setLastLoginTime(new Date());
//		queryDeviceDTO.setLastRegTime(new Date());
//		queryDeviceDTO.setLastHeartbeatTime(new Date());
//		queryDeviceDTO.setExpireDate(new Date());
//		queryDeviceDTO.setCreateTime(new Date());
//		queryDeviceDTO.setOperatorId(0);
//		queryDeviceDTO.setOperatorName("");
//		queryDeviceDTO.setRemark("");
//
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.initKey(queryDeviceDTO)));
//	}
//
//	@Test
//	public void recover() {
//		QueryDeviceDTO queryDeviceDTO = new QueryDeviceDTO();
//		queryDeviceDTO.setGroupCode("test123");
//		queryDeviceDTO.setGroupName("");
//		queryDeviceDTO.setCompanyCode("test123");
//		queryDeviceDTO.setCompanyName("");
//		queryDeviceDTO.setStoreCode("");
//		queryDeviceDTO.setDeviceId("w");
//		queryDeviceDTO.setDeviceVersion("");
//		queryDeviceDTO.setSoftwareVersion("");
//		queryDeviceDTO.setKey("lbhpscjmlmdj");
//		queryDeviceDTO.setStatus(0);
//		queryDeviceDTO.setActivityTime(new Date());
//		queryDeviceDTO.setLastLoginTime(new Date());
//		queryDeviceDTO.setLastRegTime(new Date());
//		queryDeviceDTO.setLastHeartbeatTime(new Date());
//		queryDeviceDTO.setExpireDate(new Date());
//		queryDeviceDTO.setCreateTime(new Date());
//		queryDeviceDTO.setOperatorId(0);
//		queryDeviceDTO.setOperatorName("");
//		queryDeviceDTO.setRemark("");
//
////		deviceFacade.distributeForGod(queryDeviceDTO);
//		System.out.println("测试信息:"+ gson.toJson(deviceFacade.recover(queryDeviceDTO)));
//	}

}