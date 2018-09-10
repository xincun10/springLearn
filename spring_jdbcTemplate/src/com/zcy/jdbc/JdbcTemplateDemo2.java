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

	//3.��ѯ���ض���
	@Test
	public void testList()
	{
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		dataSource.setJdbcUrl("jdbc:mysql:///test01");
//		dataSource.setUser("root");
//		dataSource.setPassword("root");
		
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test01");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//����jbdcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql = "select * from user";
		//����jdbcTemplate�ķ���
		List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(list);
	}
	
	//2.��ѯ���ض���
	@Test
	public void testObject()
	{
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test01");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//����jbdcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql = "select * from user where username=?";
		//����jdbcTemplate�ķ���
		User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "lucy");
		System.out.println(user);
	}
	
	//1.��ѯ���ɶ�������¼
	@Test
	public void testCount()
	{
		//�������ݿ���Ϣ
		DriverManagerDataSource dataSource = 
				new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test01");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//����jbdcTemplate������������Դ
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//����jdbcTemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql = "select count(*) from user";
		//����jdbcTemplate�ķ���
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	//jdbcʵ�ִ���
	@Test
	public void testJDBC()
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql:///test01", "root", "root");
			//��дsql���
			String sql = "select * from user where username=?";
			//Ԥ����sql
			psmt = conn.prepareStatement(sql);
			//���ò���ֵ
			psmt.setString(1, "lucy");
			//ִ��sql
			rs = psmt.executeQuery();
			//���������
			while(rs.next())
			{
				//�õ����ؽ��ֵ
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
				//�ر�����
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
		//1.�ӽ������������ݵõ�
		String username = rs.getString("username");
		String password = rs.getString("password");
		//2.�ѵõ������ݷ�װ����������
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
				
		return user;
	}
	
}
