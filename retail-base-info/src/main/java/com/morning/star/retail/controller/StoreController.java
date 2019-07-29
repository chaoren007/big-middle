package com.morning.star.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.dto.store.StoreCreateDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.dto.store.StoreModifyDTO;
import com.morning.star.retail.dto.store.StoreQueryDTO;
import com.morning.star.retail.facade.StoreFacade;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class StoreController {

	@Autowired
	private StoreFacade storeFacade;
	
    
	@ApiOperation(value = "新增门店")
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public void addStore(@RequestBody StoreCreateDTO storeDO) {
		storeFacade.addStore(storeDO);
	}

	@ApiOperation(value = "修改门店")
	@RequestMapping(value = "/store/{storeCode}", method = RequestMethod.PUT)
	public void modifyStore(@PathVariable String storeCode, @RequestBody StoreModifyDTO storeDO) {
	    storeFacade.modifyStore(storeDO);
	}
	
	@ApiOperation(value = "门店列表")
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public PageBean<StoreDTO> pageListStore(StoreQueryDTO storeBO) {
	    return storeFacade.pageListStore(storeBO);
	}
	
	@ApiOperation(value = "冻结门店")
	@RequestMapping(value = "/store/{storeCode}/freeze", method = RequestMethod.POST)
	public void freezeStore(@PathVariable String storeCode) {
	    storeFacade.freezeStore(storeCode);
	}
	
	@ApiOperation(value = "解冻门店")
	@RequestMapping(value = "/store/{storeCode}/unfreeze", method = RequestMethod.POST)
	public void unfreezeStore(@PathVariable String storeCode) {
	    storeFacade.unfreezeStore(storeCode);
	}
	
	@ApiOperation(value = "门店详情")
	@RequestMapping(value = "/store/{storeCode}", method = RequestMethod.GET)
	public StoreDTO getStore(@PathVariable String storeCode) {
	    return storeFacade.getStore(storeCode);
	}
	
	@ApiOperation(value = "门店编码")
	@RequestMapping(value = "/store/code", method = RequestMethod.POST)
	public String getCode() {
	    return storeFacade.getCode();
	}

}
