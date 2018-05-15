package com.ruge.test.spring.jdbcTemplate;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  14:41
 * 描述 ：JDBC测试
 */
public class JDBCTest {
    private ClassPathXmlApplicationContext context;
    private JdbcTemplate jdbcTemplate;

    {
        context = new ClassPathXmlApplicationContext("classpath:test/spring/jdbcTemplate/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    /**
     * 单个修改
     */
    @Test
    public void testUpdate() {
        String sql = "update admin set password = ? where id = ?";
        jdbcTemplate.update(sql, "pdw", 10080);
    }

    /**
     * 单个新增
     */
    @Test
    public void testInsert() {
        String sql = "insert into admin (id,username,password) values (?,?,?)";
        int i = jdbcTemplate.update(sql, 8, "topo", "topo");
        System.out.println(i);
    }

    /**
     * 批量新增
     */
    @Test
    public void testBatchInsert() {
        String sql = "insert into admin (id,username,password) values (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{1, "111", "111"});
        batchArgs.add(new Object[]{2, "222", "222"});
        batchArgs.add(new Object[]{3, "333", "333"});
        batchArgs.add(new Object[]{4, "444", "444"});
        batchArgs.add(new Object[]{5, "555", "555"});
        batchArgs.add(new Object[]{6, "666", "666"});
        batchArgs.add(new Object[]{7, "777", "777"});
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints);
    }

    /**
     * @param admin 集合参数
     * @return      返回list集合
     */
    public  List<Map<String, Object>> queryForList1(Admin admin) {
        String sql = "select * from admin where id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, admin.getId());
        return maps;
    }

    /**
     *
     * @param admin 集合参数
     * @return      返回list集合
     */
    public  List<Admin> queryForList2(Admin admin) {
        String sql = "select * from admin where id = ?";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
        Object [] args = {admin.getId()};
        List<Admin> query = jdbcTemplate.query(sql, rowMapper, admin.getId());
        return query;
    }
    @Test
    public void testDataSource() {
        DataSource dataSource = (DataSource) context.getBean("dataSource");

        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(String a){
        a="111";
        System.out.println(a);
    }
}
