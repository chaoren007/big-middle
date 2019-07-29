package com.morning.star.retail.dto;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2018/11/14 11:13
 **/
public class LoginDTO{
   private String Message;
   private String MessageCode;

    /**
     * 登陆状态 1为登陆成功
     */
   private Integer LoginResultType;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(String messageCode) {
        MessageCode = messageCode;
    }

    public Integer getLoginResultType() {
        return LoginResultType;
    }

    public void setLoginResultType(Integer loginResultType) {
        LoginResultType = loginResultType;
    }
}
  
  
   