package com.zcy.xmlanno;

import javax.annotation.Resource;

public class BookService {

	//要得到bookdao和ordersdao对象
	@Resource(name="bookDao")
	private BookDao bookDao;
	@Resource(name="ordersDao")
	private OrdersDao ordersDao;
	
	public void buy()
	{
		System.out.println("bookservice....");
		bookDao.buy();
		ordersDao.buy();
	}
}
