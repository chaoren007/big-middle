//package com.morning.star.retail.stock.repository;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.morning.star.retail.StockServer;
//import com.morning.star.retail.facade.InventoryFacade;
//import com.morning.star.retail.stock.dao.InventoryItemDao;
//import com.morning.star.retail.stock.dto.InventoryQueryDTO;
//import com.morning.star.retail.stock.entity.InventoryEntity;
//import com.morning.star.retail.stock.entity.OutstockOrderEntity;
//import com.morning.star.retail.stock.entity.ReplenishEntity;
//import com.morning.star.retail.stock.entity.repository.InventoryRepository;
//import com.morning.star.retail.stock.entity.repository.OutStockRepository;
//import com.morning.star.retail.stock.entity.repository.ReplenishRepository;
//import com.morning.star.retail.stock.vo.InventoryDetailVO;
//import com.morning.star.retail.stock.vo.InventoryItemVO;
//import com.morning.star.retail.util.Json;
//
///**
// * @author ethan
// * @create_time 2018/7/17 16:47
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = StockServer.class)
//public class ReplenishRepositoryTest {
//	@Autowired
//	private InventoryFacade inventoryFacade;
//
//	@Autowired
//	private ReplenishRepository replenishRepository;
//	@Autowired
//	private InventoryRepository inventoryRepository;
//	@Autowired
//	private InventoryItemDao inventoryItemDao;
//	@Autowired
//	private OutStockRepository outstockRepository;
//
//	@Test
//	public void save() {
//		OutstockOrderEntity findOne = outstockRepository.findOne("OSC180807182805001004");
//		findOne.setStatus(10);
//		outstockRepository.save(findOne);
//	}
//
//	@Test
//	public void save123() {
//		InventoryEntity findone = inventoryRepository.getByInventoryCode("INV180730104216001000");
//		findone.setDeleteFlag(1);
//		inventoryRepository.save(findone);
//	}
//
//
//	@Test
//	public void findOne() {
//		ReplenishEntity replenishRepositoryOne = replenishRepository.findOne(112L);
//		System.out.print(replenishRepositoryOne);
//	}
//
//	@Test
//	public void Test1() {
//		InventoryEntity entity = inventoryRepository.getByInventoryCode("INV180730104216001000");
//		System.out.println(Json.toJson(entity));
//	}
//
//	@Test
//	public void Test2() {
//		// RowBounds rowBounds = RowBoundsBuilder.build(1, 10);
//		InventoryQueryDTO dto = new InventoryQueryDTO();
//		dto.setInventoryCode("INV180730104216001000");
//		dto.setStatus(2);
//		List<InventoryItemVO> list = inventoryItemDao.selectList(dto);
//		System.out.println("============================" + list.size());
//	}
//
//	@Test
//	public void Test3() {
//
//		InventoryQueryDTO dto = new InventoryQueryDTO();
//		dto.setInventoryCode("INV180730104216001000");
//		dto.setPageNo(1);
//		dto.setPageSize(11);
//		InventoryDetailVO detail = inventoryFacade.detail(dto);
//		System.out.println(Json.toJson(detail));
//	}
//	@Test
//	public void Test4(){
//		OutstockOrderEntity findOne = outstockRepository.findOne("123");
//		System.out.println(findOne==null);
//		if(findOne!=null){
//			System.out.println(Json.toJson(findOne));
//		}
//	}
//}