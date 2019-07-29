package com.morning.star.retail.base.sms;

import com.morning.star.redis.Redis;
import com.morning.star.retail.util.RandomUtil;
import com.morning.star.retail.util.RegexUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsRemoteService {
	private Logger LOGGER = LoggerFactory.getLogger(SmsRemoteService.class);
	private static final String CAPTCHA = "CAPTCHA_";
	private static final int CAPTCHA_EXPIRED_SECONDS = 60;

	@Autowired
	private SMS sms;
	@Autowired
	private Redis redis;

	/**
	 * 发送短信
	 *
	 * @param mobile      发送手机号
	 * @param captchaType 发送类型
	 * @return
	 */
	public boolean sendCaptcha(String mobile, String captchaType) {
		String key = CAPTCHA + captchaType + "_" + mobile;
		String captcha = RandomUtil.generateNumString(6);
		String message = String.format("您的验证码是%s。如非本人操作，请忽略本短信", captcha);
		LOGGER.info("---------------- 缓存的验证码 ----------------" + redis.get(key));
		Validate.isTrue(StringUtils.isBlank(redis.get(key)), "系统60秒内只能发送一次短信验证码，请稍后操作");
		boolean result = sendMessage(mobile, message);
		Validate.isTrue(result, "发送短信验证码失败，请重新操作");
		LOGGER.info("---------------- 发送短信 ----------------" + message);
		// 缓存验证码
		redis.setex(key, captcha, CAPTCHA_EXPIRED_SECONDS);
		return result;
	}

	/**
	 * 发送短信
	 *
	 * @param mobile
	 * @return
	 */
	public boolean sendMessage(String mobile, String message) {
		Validate.notBlank(mobile, "手机号不能为空");
		Validate.isTrue(RegexUtil.isMobile(mobile), "手机号格式输入错误，请重新输入");

		try {
			return sms.sendSMS(mobile, message);
		} catch (Exception e) {
			LOGGER.error("send msg error : {}", e.getMessage());
		}
		return false;
	}

	/**
	 * 校验验证码
	 *
	 * @param mobile
	 * @param captcha
	 * @return
	 */
	public boolean checkCaptcha(String mobile, String captcha, String captchaType) {
		String key = CAPTCHA + captchaType + "_" + mobile;
		String cachedCaptcha = redis.get(key);
		Validate.isTrue(cachedCaptcha != null, "验证码已失效，请重新操作");
		Validate.isTrue(StringUtils.isNotBlank(cachedCaptcha) && cachedCaptcha.equals(captcha), "验证码输入错误，请重新输入");
		redis.delete(key);
		return true;
	}

}
