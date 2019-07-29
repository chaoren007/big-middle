package com.morning.star.retail.utils;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/13 16:25
 **/
public class StarNumFormat {
    /**
     * 前面补零
     * @param num 原数字
     * @param size 长度
     * @return
     */
    public  static String insertZore(Integer num, Integer size){
        return String.format("%0"+size+"d", num);
    }
}
  
  
   