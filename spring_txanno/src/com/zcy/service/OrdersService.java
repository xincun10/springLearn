package com.zcy.service;

import org.springframework.transaction.annotation.Transactional;

import com.zcy.dao.OrdersDao;

@Transactional
public class OrdersService {

	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	//调用dao的方法
	//业务逻辑层，写特殊业务
	public void accountMoney()
	{
		//xianyu少10
		ordersDao.lessMoney();
		//出现异常
		int i = 10/0;
		//hanren多10
		ordersDao.moreMoney();
	}
	
}
