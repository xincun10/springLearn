package com.zcy.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo {

	//1.��Ӳ���
	@Test
	public void add()
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
		String sql = "insert into user values(?,?)";
		int rows = jdbcTemplate.update(sql,"lucy","250");
	}
	
	//2.�޸ġ�ɾ������
	@Test
	public void update()
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
		//����sql����޸�
//		String sql = "update user set password=? where username=?";
//		int rows = jdbcTemplate.update(sql,"330","lucy");
		//����update����ʵ��ɾ��
		String sql = "delete from user where username=?";
		int rows = jdbcTemplate.update(sql, "lucy");
	}
	
}
