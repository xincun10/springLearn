package com.zcy.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//��Ǯ�ķ���
	public void lessMoney()
	{
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql, 10, "xianyu");
	}
	//��Ǯ�ķ���
	public void moreMoney()
	{
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 10, "hanren");
	}
}
