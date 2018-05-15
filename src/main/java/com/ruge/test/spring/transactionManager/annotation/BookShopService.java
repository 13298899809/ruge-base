package com.ruge.test.spring.transactionManager.annotation;

public interface BookShopService {
	/**
	 * @param username 用户名
	 * @param isbn 书号
	 */
	public void purchase(String username, String isbn);
	
}
