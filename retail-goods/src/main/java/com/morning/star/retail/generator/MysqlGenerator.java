package com.morning.star.retail.generator;

/**
 * @author ethan
 * @create_time 2019/3/7 10:11
 */
public class MysqlGenerator {

	public static void main(String[] args) {
		//数据库连接地址
		String dbUrl = "jdbc:mysql://119.29.66.230:3306/retail_goods?autoReconnect=true&autoReconnectForPools=true&interactiveClient=true&useUnicode=true&characterEncoding=UTF-8";
		//密码
		String passWord = "DIeeUIswo#HUD!r4";
		//项目名
		String projectName = "retail-goods";
		//项目包结构
		String parent = "com.morning.star.retail";
		/*try {
			TemplateGernate templateGernate = new TemplateGernate(dbUrl, passWord, projectName, parent);
			templateGernate.gernateCode();
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
	}

}
