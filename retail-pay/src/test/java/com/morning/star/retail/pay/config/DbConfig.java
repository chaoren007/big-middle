package com.morning.star.retail.pay.config;

//import com.baidu.disconf.client.common.annotations.DisconfFile;
//import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2017/6/30.
 */
@Service
@Scope("singleton")
//@DisconfFile(filename = "db.properties")
public class DbConfig {

    private String url;

//    @DisconfFileItem(name = "jdbc.url",associateField = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Test
    public void test(){
        System.out.println("");
    }

}
