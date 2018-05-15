package com.ruge.test.spring.transactionManager.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private IBookShopDao bookShopDao;

    /**
     * 事务的传播行为
     * PROPAGATION_REQUIRED--业务方法需要在一个事务中运行，如果方法运行时，已处在一个事务中，那么就加入该事务，否则自己创建一个新的事务。这是spring默认的传播行为。
     * PROPAGATION_REQUIRED--支持当前事务，假设当前没有事务。就新建一个事务。(这是最常见的选择。)
     * PROPAGATION_SUPPORTS--支持当前事务，假设当前没有事务，就以非事务方式运行。
     * PROPAGATION_MANDATORY--支持当前事务，假设当前没有事务，就抛出异常。
     * PROPAGATION_REQUIRES_NEW--新建事务，假设当前存在事务。把当前事务挂起。
     * PROPAGATION_NOT_SUPPORTED--以非事务方式运行操作。假设当前存在事务，就把当前事务挂起。
     * 事务的隔离级别（Isolation Level）
     * DEFAULT （默认） 这是一个PlatfromTransactionManager默认的隔离级别，使用数据库默认的事务隔离级别.另外四个与JDBC的隔离级别相对应
     * READ_UNCOMMITTED （读未提交） 这是事务最低的隔离级别，它允许另外一个事务可以看到这个事务未提交的数据。这种隔离级别会产生脏读，不可重复读和幻像读。
     * READ_COMMITTED （读已提交）  保证一个事务修改的数据提交后才能被另外一个事务读取。另外一个事务不能读取该事务未提交的数据。这种事务隔离级别可以避免脏读出现，但是可能会出现不可重复读和幻像读
     * REPEATABLE_READ (最常使用) （可重复读） 这种事务隔离级别可以防止脏读，不可重复读。但是可能出现幻像读。它除了保证一个事务不能读取另一个事务未提交的数据外，还保证了不可重复读
     * SERIALIZABLE（串行化）  这是花费最高代价但是最可靠的事务隔离级别。事务被处理为顺序执行。除了防止脏读，不可重复读外，还避免了幻像读。
     *      隔离级别解决事务并行引起的问题
     *           Dirty reads non-repeatable reads phantom reads
     *           Serializable 不会 不会 不会
     *           REPEATABLE READ 不会 不会 会
     *           READ COMMITTED 不会 会 会
     *           Read Uncommitted 会 会 会
     * 默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚. 也可以通过对应的属性进行设置. 通常情况下去默认值即可.
     *
     */
    @Transactional/*(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 3)*/
    @Override
    public void purchase(String username, String isbn) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        /**
         * 获取书的单价
         */
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        /**
         * 获取书的库存
         */
        bookShopDao.updateBookStock(isbn);
        /**
         * 3更新用户的余额
         */
        bookShopDao.updateUserAccount(username, price);
    }

}
