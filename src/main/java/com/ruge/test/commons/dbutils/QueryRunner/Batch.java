package com.ruge.test.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 爱丽丝、如歌  创建于 2018/6/16 10:26
 * 说明:  批处理
 */
public class Batch {
    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mybatis?serverTimezone=UTC", "root", "root");
        conn.setAutoCommit(false);
        QueryRunner runner = new QueryRunner();
        int update = runner.update(conn, "insert into sys_user(user_id,user_name) values (?,?)", 4, 4);
        conn.commit();
        DbUtils.close(conn);
    }
}
