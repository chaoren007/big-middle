package zk;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2019/3/13 14:20
 **/


import com.morning.star.retail.utils.zk.zkUtils;

import java.util.ArrayList;


public class zkTest {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        zkUtils zkUtils = new zkUtils();
        String chaoren = zkUtils.zkIncr("test",6); //不要修改path测试 , 避免跟业务冲突

        //
        new ArrayList<>();
        System.out.print(chaoren);
    }
}

  
   