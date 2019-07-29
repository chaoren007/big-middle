package com.morning.star.retail.controller;

import com.morning.star.retail.facade.*;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.WebBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * wms服务接口
 *
 * @author kimhuhg
 */
@Api(tags = "内部测试WMS接口")
@RestController
@RequestMapping("/api/wms")
public class WmsTestController {

	@Autowired
	private PurchaseWmsFacade purchaseWmsFacade;

	@Autowired
	private OutStockWmsFacade outStockWmsFacade;

	@Autowired
	private MoveStockWmsFacade moveStockWmsFacade;

	@Autowired
	private CustomerWmsFacade customerWmsFacade;

	@Autowired
	private ThirdServiceFailFacade thirdServiceFailFacade;

	@ApiOperation(value = "重试错误请求")
	@RequestMapping(value = "/retry/{id}", method = RequestMethod.GET)
	public WebBean retryFail(@PathVariable("id") Long id) {
		ThirdServiceFailDTO dto = thirdServiceFailFacade.reTry(id);
		return WebBean.ok(dto);
	}

	@ApiOperation(value = "添加客户信息")
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public WebBean addCustomer(@RequestBody SupplierWmsDTO dto) {
		customerWmsFacade.add(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "采购订单新增")
	@RequestMapping(value = "/purchase/add", method = RequestMethod.POST)
	public WebBean purchase(@RequestBody PurchaseSubmitWmsDTO dto) {
		purchaseWmsFacade.submit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "采购订单关闭")
	@RequestMapping(value = "/purchase/close", method = RequestMethod.POST)
	public WebBean purchaseClose(@RequestBody PurchaseSubmitWmsDTO dto) {
		purchaseWmsFacade.close(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "退供应商出库")
	@RequestMapping(value = "/purchase/out", method = RequestMethod.POST)
	public WebBean purchaseOut(@RequestBody PurchaseSubmitWmsDTO dto) {
		purchaseWmsFacade.out(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "销售出库")
	@RequestMapping(value = "/outStock/push/sell", method = RequestMethod.POST)
	public WebBean outStockSell(@RequestBody OutStockSubmitWmsDTO dto) {
		outStockWmsFacade.sellOutSubmit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "销售出库TEST")
	@RequestMapping(value = "/outStock/push/sell/test", method = RequestMethod.POST)
	public WebBean outStockSellTest() {
		List<OutStockSubmitWmsDTO> list = new ArrayList<>();
		list.add(new OutStockSubmitWmsDTO("WMS" + UniqueNoUtils.next(),
			"C18090521154818922",
			"18670600891",
			"ethan",
			"东郊小镇第六街区 (江宁麒麟镇)麒东路777号",
			"ethan",
			"2019-01-05 00:00:00",
			"GS00000038",
			"CK100011",
			"test"));
		list.add(new OutStockSubmitWmsDTO("WMS" + UniqueNoUtils.next(),
			"C18090521154818923",
			"18670600899",
			"ethan1",
			"书院南路与友谊西路交汇处东南角（友谊路779号）",
			"ethan",
			"2019-01-05 00:00:00",
			"GS00000038",
			"CK100011",
			"test"));
		list.add(new OutStockSubmitWmsDTO("WMS" + UniqueNoUtils.next(),
			"C18090521154818924",
			"18670600805",
			"ethan2",
			"书院南路与友谊西路交汇处东南角（友谊路800号）",
			"ethan",
			"2019-01-05 00:00:00",
			"GS00000038",
			"CK100011",
			"test"));
		list.add(new OutStockSubmitWmsDTO("WMS" + UniqueNoUtils.next(),
			"C18090521154818925",
			"18670600804",
			"ethan3",
			"岳麓大道与杜鹃路交汇处西北角",
			"ethan",
			"2019-01-05 00:00:00",
			"GS00000038",
			"CK100011",
			"test"));
		list.add(new OutStockSubmitWmsDTO("WMS" + UniqueNoUtils.next(),
			"C18090521154818926",
			"18670600814",
			"ethan4",
			"枫林路与银盆南路交汇处西北角（交警大楼西侧）",
			"ethan",
			"2019-01-05 00:00:00",
			"GS00000038",
			"CK100011",
			"test"));
		Random random = new Random();
		List<OutStockDetailSubmitWmsDTO> detail = new ArrayList<>();
		detail.add(new OutStockDetailSubmitWmsDTO("3001010017", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010018", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010019", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("11010010019", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010001", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010005", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010006", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010007", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010008", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010009", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010010", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010012", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010013", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("11010030002", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("1001010018", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010023", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010022", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010014", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010011", new BigDecimal(random.nextInt(200) + 1)));
		detail.add(new OutStockDetailSubmitWmsDTO("3001010004", new BigDecimal(random.nextInt(200) + 1)));


		OutStockSubmitWmsDTO dto = list.get(random.nextInt(list.size()));
		dto.setDetail(detail.subList(0, random.nextInt(detail.size() - 5) + 5));

		outStockWmsFacade.sellOutSubmit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "调拨出库")
	@RequestMapping(value = "/outStock/push/transfer", method = RequestMethod.POST)
	public WebBean outStockTransfer(@RequestBody OutStockSubmitWmsDTO dto) {
		outStockWmsFacade.transferOutSubmit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "销售退货入库")
	@RequestMapping(value = "/inStock/push/sell", method = RequestMethod.POST)
	public WebBean inStockSell(@RequestBody OutStockSubmitWmsDTO dto) {
		outStockWmsFacade.sellInSubmit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "调拨入库")
	@RequestMapping(value = "/inStock/push/transfer", method = RequestMethod.POST)
	public WebBean inStockTransfer(@RequestBody OutStockSubmitWmsDTO dto) {
		outStockWmsFacade.transferInSubmit(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "移库信息推送测试(推送类型：3-其他入库单接口，2-移库单接口）")
	@RequestMapping(value = "/moveStock/push", method = RequestMethod.POST)
	public WebBean push(@RequestBody MoveStockWmsDTO dto) {
		moveStockWmsFacade.add(dto);
		return WebBean.ok();
	}
}
