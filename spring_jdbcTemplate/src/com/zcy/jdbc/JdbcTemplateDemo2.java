package com.zcy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcTemplateDemo2 {

	//3.查询返回对象
	@Test
	public void testList()
	{
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		dataSource.setJdbcUrl("jdbc:mysql:///test01");
//		dataSource.setUser("root");
//		dataSource.setPassword("root");
		
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
		String sql = "select * from user";
		//调用jdbcTemplate的方法
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list);
	}
	
	//2.查询返回对象
	@Test
	public void testObject()
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
		String sql = "select * from user where username=?";
		//调用jdbcTemplate的方法
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "lucy");
		System.out.println(user);
	}
	
	//1.查询表由多少条记录
	@Test
	public void testCount()
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
		String sql = "select count(*) from user";
		//调用jdbcTemplate的方法
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	//jdbc实现代码
	@Test
	public void testJDBC()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			conn = DriverManager.getConnection("jdbc:mysql:///test01", "root", "root");
			//编写sql语句
			String sql = "select * from user where username=?";
			//预编译sql
			psmt = conn.prepareStatement(sql);
			//设置参数值
			psmt.setString(1, "lucy");
			//执行sql
			rs = psmt.executeQuery();
			//遍历结果集
			while(rs.next())
			{
				//得到返回结果值
				String username = rs.getString("username");
				String password = rs.getString("password");
				User user = new User();
				user.setPassword(password);
				user.setUsername(username);
				System.out.println(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//关闭连接
				rs.close();
				psmt.close();
				conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}

class MyRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		//1.从结果集里面把数据得到
		String username = rs.getString("username");
		String password = rs.getString("password");
		//2.把得到的数据封装到对象里面
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
				
		return user;
	}
	
}
