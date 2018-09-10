package com.zcy.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo {

	//1.添加操作
	@Test
	public void add()
	{
		//设置数据库信息
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test01");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//创建jbdcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//调用jdbcTemplate对象里面的方法实现操作
		//创建sql语句
		String sql = "insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql,"lucy","250");
	}
	
	//2.修改、删除操作
	@Test
	public void update()
	{
		//设置数据库信息
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test01");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//创建jbdcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//调用jdbcTemplate对象里面的方法实现操作
		//创建sql语句修改
//		String sql = "update user set password=? where username=?";
//		int rows = jdbcTemplate.update(sql,"330","lucy");
		//调用update方法实现删除
		String sql = "delete from user where username=?";
		int rows = jdbcTemplate.update(sql, "lucy");
	}
	
}
