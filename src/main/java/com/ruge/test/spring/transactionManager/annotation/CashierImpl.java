package com.ruge.test.spring.transactionManager.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    /**
     * 购买多本书
     *
     * @param username 用户名
     * @param isbns    购买多本书的id集合
     */
    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }

}
