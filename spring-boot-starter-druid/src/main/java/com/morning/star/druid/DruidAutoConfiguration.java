package com.morning.star.druid;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * 获取数据源
 * @author zhouwen
 */
@Configuration
public class DruidAutoConfiguration {
    
	
	/**
	 * 数据库的连接地址
	 */
    private static final String DB_URL ="jdbc.url";
    
    /**
     * 数据库的用户名
     */
    private static final String DB_USERNAME ="jdbc.username";
    
    /**
     * 数据库的密码
     */
    private static final String DB_PASSWORD="jdbc.password";
    
    /**
     * 数据库最大连接数
     */
    private static final String DB_MAXACTIVE="jdbc.maxActive";
    
    /**
     * 数据库最大连接数
     */
    private static final String DF_DB_MAXACTIVE="20";
    
    
    /**
     * 初始化连接池
     */
    private static final String DB_INITIALSIZE="jdbc.initialSize";
    
    /**
     * 初始化连接池
     */
    private static final String DF_DB_INITIALSIZE="3";
    
    /**
     * 最小连接数
     */
    private static final String DB_MINIDLE="jdbc.minIdle";
    
    /**
     * 最小连接数
     */
    private static final String DF_DB_MINIDLE="3";
    
    
    /**
     * 最大等待时长
     */
    private static final String DB_MAXWAIT="jdbc.maxWait";
    
    /**
     * 最大等待时长
     */
    private static final String DF_DB_MAXWAIT="60000";
    
    
    /**
     * timeBetweenEvictionRunsMillis间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    private static final String DB_CHECKTIME="jdbc.timeBetweenEvictionRunsMillis";
    
    /**
     * timeBetweenEvictionRunsMillis间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    private static final String DF_DB_CHECKTIME="60000";
    
    /**
     *  minEvictableIdleTimeMillis一个连接在池中最小空闲的时间，单位是毫秒
     */
    private static final String DB_MINEVICTABLE="jdbc.minEvictableIdleTimeMillis";
   
    /**
     *  minEvictableIdleTimeMillis一个连接在池中最小空闲的时间，单位是毫秒
     */
    private static final String DF_DB_MINEVICTABLE="300000";
   
    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句。 
	如果validationQuery为null，testOnBorrow、testOnReturn、 
	testWhileIdle都不会其作用。
     */
    private static final String DB_VALIDATE="jdbc.validationQuery";
    
   
    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句。 
	如果validationQuery为null，testOnBorrow、testOnReturn、 
	testWhileIdle都不会其作用。
     */
    private static final String DF_DB_VALIDATE="select 1 from dual";
    
    /**
     * 建议配置为true，不影响性能，并且保证安全性。 
		申请连接的时候检测，如果空闲时间大于 
		timeBetweenEvictionRunsMillis， 
		执行validationQuery检测连接是否有效。
     */
    private static final String DB_TESTWHILE="jdbc.testWhileIdle";
    
    /**
     * 建议配置为true，不影响性能，并且保证安全性。 
		申请连接的时候检测，如果空闲时间大于 
		timeBetweenEvictionRunsMillis， 
		执行validationQuery检测连接是否有效。
     */
    private static final String DF_DB_TESTWHILE="true";
    
	
	/**
     * druid初始化
     * @return
     * @throws SQLException
     */
    @Primary //默认数据源
    @Bean(name = "dataSource",destroyMethod = "close")
    public DruidDataSource Construction(Environment env) throws SQLException {
    	  
    	   DruidDataSource datasource = new DruidDataSource();  
           //初始化数据源
           datasource.setUrl(EvnUtils.getStringValue(env,DB_URL));  
           datasource.setUsername(EvnUtils.getStringValue(env,DB_USERNAME));  
           datasource.setPassword(EvnUtils.getStringValue(env,DB_PASSWORD));  
           datasource.setMaxActive(EvnUtils.getIntValue(env,DB_MAXACTIVE,DF_DB_MAXACTIVE));
           datasource.setInitialSize(EvnUtils.getIntValue(env,DB_INITIALSIZE,DF_DB_INITIALSIZE));
           datasource.setMinIdle(EvnUtils.getIntValue(env,DB_MINIDLE,DF_DB_MINIDLE));
           datasource.setMaxWait(EvnUtils.getIntValue(env,DB_MAXWAIT,DF_DB_MAXWAIT));
           datasource.setTimeBetweenConnectErrorMillis(EvnUtils.getIntValue(env,DB_CHECKTIME,DF_DB_CHECKTIME));
           datasource.setMinEvictableIdleTimeMillis(EvnUtils.getIntValue(env,DB_MINEVICTABLE,DF_DB_MINEVICTABLE));
           datasource.setValidationQuery(EvnUtils.getStringValue(env,DB_VALIDATE,DF_DB_VALIDATE));
           datasource.setTestWhileIdle(EvnUtils.getBooleanValue(env,DB_TESTWHILE,DF_DB_TESTWHILE));
           List<Filter> filters = new ArrayList<Filter>();
           StatFilter statFilter = new StatFilter();
           statFilter.setMergeSql(true);
           statFilter.setLogSlowSql(true);
           statFilter.setSlowSqlMillis(600);
           filters.add(statFilter);
           datasource.setProxyFilters(filters);
          try {
        	  datasource.init();
        } catch (SQLException e) {
            throw new RuntimeException("druid datasource init fail:" + datasource.getUrl(), e);
        }
        return datasource;
    }
    

}
