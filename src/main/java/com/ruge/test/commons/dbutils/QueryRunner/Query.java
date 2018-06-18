package com.ruge.test.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 20:14
 * 说明:  commons-dbutils 查询工具类
 */
public class Query {
    /**
     * 返回对象list集合
     * BeanHandler: 查询返回单个对象
     * BeanListHandler: 查询返回list集合，集合元素是指定的对象
     * ArrayHandler, 查询返回结果记录的第一行，封装对对象数组, 即返回：Object[]
     * ArrayListHandler, 把查询的每一行都封装为对象数组，再添加到list集合中
     * ScalarHandler 查询返回结果记录的第一行的第一列  (在聚合函数统计的时候用)
     * MapHandler  查询返回结果的第一条记录封装为map
     */
    @Test
    public void test1() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=UTC", "root", "root");
        QueryRunner runner = new QueryRunner();
        Object [] params = {1,1};
        List<SysUser> query = runner.query(conn, "select * from sys_user where user_id = ? and user_status = ? ", new BeanListHandler<SysUser>(SysUser.class),params);
        for (SysUser s : query
                ) {
            System.out.println(s);
        }
        DbUtils.close(conn);
    }

    /**
     * 返回list集合 查询条件拼接
     */
    @Test
    public void test2() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=UTC", "root", "root");
        QueryRunner runner = new QueryRunner();
        String sqlWhere = "";
        String userName = "爱丽丝、如歌";
        if(!StringUtils.isBlank("userName")){
            sqlWhere += " and user_name = '" + userName + "'";
        }
        List<SysUser> query = runner.query(conn, "select * from sys_user where 1=1 "+sqlWhere, new BeanListHandler<SysUser>(SysUser.class));
        for (SysUser s : query
                ) {
            System.out.println(s);
        }
        DbUtils.close(conn);
    }

    /**
     * MapListHandler
     * 会将结果集中的数据转换为一个集合，集合中的数据为对应行转换的键值对，键为列名
     */
    @Test
    public void test3() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=UTC", "root", "root");
        QueryRunner runner = new QueryRunner();
        String sqlWhere = "";
        String userName = "爱丽丝、如歌";
        if(!StringUtils.isBlank("userName")){
            sqlWhere += " and user_name = '" + userName + "'";
        }
        List<Map<String, Object>> query = runner.query(conn, "select * from sys_user where 1=1 " + sqlWhere, new MapListHandler());
        for (Map m: query
             ) {
            System.out.println(m);
        }
        DbUtils.close(conn);
    }

    /**
     * 查询count返回一个number
     */
    @Test
    public void test4() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=UTC", "root", "root");
        QueryRunner runner = new QueryRunner();
        String sqlWhere = "";
        String userName = "爱丽丝、如歌";
        if(!StringUtils.isBlank("userName")){
            sqlWhere += " and user_name = '" + userName + "'";
        }
        Number query = runner.query(conn, "select count(1) from sys_user where 1=1 " + sqlWhere, new ScalarHandler<Number>());
        System.out.println(query);
        DbUtils.close(conn);
    }
}
