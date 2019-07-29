package com.morning.star.retail.controller;

import com.morning.star.retail.bean.WebJsonBean;
import com.retail.push.msg.api.BindingEquipmentFacade;
import com.retail.push.msg.api.dto.PushUserAddDTO;
import com.retail.push.msg.api.info.PushParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2018/7/17.
 */
@RestController
@RequestMapping("/api/v1/netty")
public class BindingEquipmentController {

	@Value("${netty.post}")
	private Integer port;

	@Autowired
	private BindingEquipmentFacade bindingEquipmentFacade;

	@ApiOperation(value = "获取netty地址")
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public WebJsonBean getAddress() {
		Map<String, String> map = new HashMap<>();
		map.put("host", "119.29.66.230");
		map.put("port", port.toString());
		return WebJsonBean.success(map);
	}

	@ApiOperation(value = "查询门店列表")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(PushUserAddDTO dto) {
		bindingEquipmentFacade.loginBinding(dto);
	}

	@ApiOperation(value = "给所有门店下的账户推送消息")
	@RequestMapping(value = "/msg/store", method = RequestMethod.POST)
	public WebJsonBean pushByStore(String storeCode, PushParams msg) {
		bindingEquipmentFacade.pushMsgByStore(storeCode, msg);
		return WebJsonBean.success();
	}

	@ApiOperation(value = "指定账户推送消息")
	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public WebJsonBean push(Long uin, PushParams msg) {
		bindingEquipmentFacade.pushMsg(uin, msg);
		return WebJsonBean.success();
	}

	@ApiOperation(value = "向未登陆用户发送消息")
	@RequestMapping(value = "/msg/no-login", method = RequestMethod.POST)
	public WebJsonBean pushNoLogin(PushParams msg) {
		bindingEquipmentFacade.pushMsgNoLogin(msg);
		return WebJsonBean.success();
	}

}
