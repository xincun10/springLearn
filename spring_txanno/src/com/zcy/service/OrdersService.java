package com.zcy.service;

import org.springframework.transaction.annotation.Transactional;

import com.zcy.dao.OrdersDao;

@Transactional
public class OrdersService {

	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
	
	//����dao�ķ���
	//ҵ���߼��㣬д����ҵ��
	public void accountMoney()
	{
		//xianyu��10
		ordersDao.lessMoney();
		//�����쳣
		int i = 10/0;
		//hanren��10
		ordersDao.moreMoney();
	}
	
}
