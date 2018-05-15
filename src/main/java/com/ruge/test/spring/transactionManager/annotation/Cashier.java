package com.ruge.test.spring.transactionManager.annotation;

import java.util.List;

public interface Cashier {
	/**
	 * @param username 用户名
	 * @param isbns 购买多本书的id集合
	 */
	public void checkout(String username, List<String> isbns);
	
}
