package com.morning.star.retail.order.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.order.domain.Result;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof OrderException){
            OrderException centerException = (OrderException) e;
            return Result.fail(-1,centerException.getMessage());
        }else {
            return Result.fail(-99,"订单系统异常！："+e.getMessage());
        }
    }
}
