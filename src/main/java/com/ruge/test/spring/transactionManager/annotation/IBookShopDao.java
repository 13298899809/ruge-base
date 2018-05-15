package com.ruge.test.spring.transactionManager.annotation;

public interface IBookShopDao {
    /**
     * 根据书号获取书的单价
     * @param isbn  书号
     * @return 书的单价
     */
    public int findBookPriceByIsbn(String isbn);

    /**
     * 根据书号更新书的库存
     * @param isbn 书号
     * @return 库存
     */
    public void updateBookStock(String isbn);

    /**
     * 更新用户的账户余额
     * @param username 用户名
     * @param price   书的价格
     */
    public void updateUserAccount(String username, int price);
}
