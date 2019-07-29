package com.morning.star.retail.admin.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.exception.RetailErrorCode;
import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.shiro.bean.LoginUser;
import com.morning.star.retail.shiro.token.TokenManager;

public class AdminController {

    /**
     * 获取缓存的用户信息
     *
     * @return
     */
    protected AdminLoginContent getLoginAdmin() {
        LoginUser user = TokenManager.getLoginUser();
        return ObjectCopier.copyObject(AdminLoginContent.class, user);
    }

    protected ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();

    @ModelAttribute
    protected void setResponse(HttpServletResponse response) {
        this.responseHolder.set(response);
    }

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        DateEditor dateEditor = new DateEditor();
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    private static class DateEditor extends PropertiesEditor {
        private final static FastDateFormat timeFormate = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        private final static FastDateFormat dateFormate = FastDateFormat.getInstance("yyyy-MM-dd");
        private final static Logger logger = LoggerFactory.getLogger(DateEditor.class);

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (StringUtils.isEmpty(text))
                return;

            if (text.contains("-")) {
                Date date = null;
                try {
                    date = text.length() == 10 ? dateFormate.parse(text) : timeFormate.parse(text);
                } catch (ParseException e) {
                    logger.error("error while DateEditor parse : {}, error type : {}", text, e.getClass().getSimpleName());
                }
                setValue(date);
            } else {
                setValue(StringUtils.isBlank(text) ? null : new Date(Long.valueOf(text)));
            }

        }

        @Override
        public String getAsText() {
            Date date = (Date) getValue();
            return date == null ? null : String.valueOf(date.getTime());
        }
    }

    protected void download(String fileName, SXSSFWorkbook wb) {
        try {
            HttpServletResponse response = responseHolder.get();
//            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 入参异常
     */
    protected void paramsError() {
    	throw new IllegalArgumentException("入参异常");
    }

    /**
     * 入参异常
     */
    protected void paramsError(String errorMsg) {
    	throw new IllegalArgumentException(errorMsg + "入参异常");
    }

    /**
     * 返回成功结果
     *
     * @return
     */
    protected WebJsonBean success() {
        return new WebJsonBean(CODE.SUCCESS);
    }

    /**
     * 返回成功结果
     *
     * @param data 响应数据
     * @return
     */
    protected WebJsonBean success(Object data) {
        return new WebJsonBean(CODE.SUCCESS, data);
    }

    /**
     * 返回失败结果
     *
     * @return
     */
    protected WebJsonBean fail() {
        return new WebJsonBean(CODE.FAIL);
    }

    /**
     * 返回失败结果
     *
     * @param data 响应数据
     * @return
     */
    protected WebJsonBean fail(Object data) {
        return new WebJsonBean(CODE.FAIL, data);
    }

    /**
     * 失败结果
     *
     * @param data
     * @return
     */
    protected WebJsonBean fail(CODE data) {
        return new WebJsonBean(data);
    }


    protected Date endTimeOf(Date date) {
        if (date == null) {
            return null;
        }
        return Date.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                .atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }

    protected Date startTimeOf(Date date) {
        if (date == null) {
            return null;
        }
        return Date.from(
                date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .atTime(LocalTime.MIN)
                        .atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}
