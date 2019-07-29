package com.morning.star.retail.group.group;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.morning.star.retail.Main;
import com.morning.star.retail.facade.GroupFacade;

/**
 * @author kimhuhg
 * @create_time 2018/7/26 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Main.class)
public class GroupFacadeTest {

	@Autowired
	private GroupFacade groupFacade;

	private Gson gson = new Gson();

//	@Test
//	public void findAll() {
//		GroupQueryDTO queryGroupDTO = new GroupQueryDTO();
//		queryGroupDTO.setGroupCode("JT");
//		PageBean<GroupInfoDTO> groupInfoDTOPageBean = groupFacade.pageList(queryGroupDTO);
//		System.out.println("获取集团信息:"+ gson.toJson(groupInfoDTOPageBean));
//	}
//
//	@Test
//	public void getCode() {
//		String code = groupFacade.getCode();
//		System.out.println("获取集团信息:"+ gson.toJson(code));
//	}
//
//	@Test
//	public void listGroup() {
//		GroupQueryDTO queryGroupDTO = new GroupQueryDTO();
//		queryGroupDTO.setGroupCode("JT");
//		PageBean<GroupInfoDTO> groupInfoDTOS = groupFacade.listGroup(queryGroupDTO);
//		System.out.println("获取集团信息:"+ gson.toJson(groupInfoDTOS));
//	}
//
//	@Test
//	public void getGroupInfo() {
//		GroupQueryDTO queryGroupDTO = new GroupQueryDTO();
//		queryGroupDTO.setGroupCode("JT00000018");
//		GroupInfoDTO groupInfoDTOS = groupFacade.getGroupInfo(queryGroupDTO);
//		System.out.println("获取集团信息:"+ gson.toJson(groupInfoDTOS));
//	}
//
//	@Test
//	public void addGroup() {
//		GroupCreateDTO createGroupDTO = new GroupCreateDTO();
//		createGroupDTO.setGroupCode("12");
//		createGroupDTO.setGroupName("1test");
//		createGroupDTO.setProvinceId(0);
//		createGroupDTO.setProvince("1");
//		createGroupDTO.setCityId(0);
//		createGroupDTO.setCity("1");
//		createGroupDTO.setDistrictId(0);
//		createGroupDTO.setDistrict("1");
//		createGroupDTO.setAddress("1");
//		createGroupDTO.setType(1);
//		createGroupDTO.setRoleIds("1");
//		createGroupDTO.setGroupAccessIds("1");
//		createGroupDTO.setIsModifyRoleIds(0);
//		createGroupDTO.setCreator("1");
//		createGroupDTO.setCreatorName("1");
//		createGroupDTO.setMerchantCode("1");
//
//		groupFacade.addGroup(createGroupDTO);
//	}
//
//	@Test
//	public void modify() {
//		GroupModifyDTO modifyGroupDTO = new GroupModifyDTO();
//		modifyGroupDTO.setGroupCode("1");
//		modifyGroupDTO.setGroupName("123");
//		modifyGroupDTO.setProvinceId(0);
//		modifyGroupDTO.setProvince("1");
//		modifyGroupDTO.setCityId(0);
//		modifyGroupDTO.setCity("1");
//		modifyGroupDTO.setDistrictId(0);
//		modifyGroupDTO.setDistrict("1");
//		modifyGroupDTO.setAddress("1");
//		modifyGroupDTO.setType(0);
//		modifyGroupDTO.setRoleIds("1");
//		modifyGroupDTO.setGroupAccessIds("1");
//		groupFacade.modify(modifyGroupDTO);
//	}
//
//	@Test
//	public void delete() {
//		GroupDeleteDTO deleteGroupDTO = new GroupDeleteDTO();
//		deleteGroupDTO.setGroupCode("1");
//		deleteGroupDTO.setOperatorId(0);
//		deleteGroupDTO.setOperatorName("1");
//
//		groupFacade.delete("1");
////		System.out.println("获取集团信息:"+ gson.toJson(code));
//	}

}