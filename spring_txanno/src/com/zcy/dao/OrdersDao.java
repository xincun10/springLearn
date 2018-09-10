package com.zcy.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//少钱的方法
	public void lessMoney()
	{
		String sql = "update account set salary=salary-? where username=?";
		jdbcTemplate.update(sql, 10, "xianyu");
	}
	//多钱的方法
	public void moreMoney()
	{
		String sql = "update account set salary=salary+? where username=?";
		jdbcTemplate.update(sql, 10, "hanren");
	}
}
