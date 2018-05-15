package com.ruge.test.mybatis.helloWorld.controller;

import com.ruge.test.mybatis.helloWorld.dao.EmployeeMapper;
import com.ruge.test.mybatis.helloWorld.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-12  9:32
 * 描述 ： 1 SqlSession 类似 Connection  使用完必须关闭！！！
 * 2 mybatis 会为接口生成一个代理对象
 */
public class HelloWorldController {
    /**
     * 获取SqlSessionFactory
     */
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "test/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


    /**
     * 不使用接口的方式
     */
    @Test
    public void test1() throws IOException {
        /**
         * 1 根据mybatis.xml配置文件 创建一个 SqlSessionFactory
         */
        HelloWorldController demo = new HelloWorldController();
        String resource = "test/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /**
         * 2 获取 SqlSession 实例
         */
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Employee employee1 = session.selectOne("unInterSelectEmp", 1);
            System.out.println(employee1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * 使用接口的方式进行映射
     */
    @Test
    public void test2() {
        SqlSession sqlSession = null;
        /**
         * 1 获取sqlsessionfactory
         */
        try {
            SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
            /**
             * 2 获取sqlSession
             */
            sqlSession = sqlSessionFactory.openSession();
            /**
             * 3 获取接口的实现类
             */
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            /**
             * 4
             */
            List<Employee> employees = mapper.selectEmp(1);
            System.out.println(employees);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    /**
     * 测试增删改
     */
    @Test
    public void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        /**
         * sqlSessionFactory.openSession(); 手动提交
         * sqlSessionFactory.openSession(true); 自动提交
         */
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        /**
         * 1 增加
         */
        Employee employee = new Employee(null,"李四","男","李四@qq.com");
        mapper.insertEmp(employee);
        System.out.println(employee.getId());
        /**
         * 2 修改
         */
        //Employee employee = new Employee(2,"王五","男","王五@qq.com");
        //mapper.updateEmp(employee);
        /**
         * 3 删除
         */
        //mapper.deleteEmp(2);
        sqlSession.commit();
        sqlSession.close();
    }

    public String getRealPath() throws IOException {
        /**
         * 第一种：获取类加载的根路径
         */
        String a = this.getClass().getResource("/").getPath();
        System.out.println(a);
        /**
         * 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录
         */
        String b = this.getClass().getResource("").getPath();
        // 第二种：获取项目路径    D:\git\daotie\daotie
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);


        // 第三种：  file:/D:/git/daotie/daotie/target/classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);


        // 第四种： D:\git\daotie\daotie
        System.out.println(System.getProperty("user.dir"));
        /*
         * 结果： C:\Documents and Settings\Administrator\workspace\projectName
         * 获取当前工程路径
         */

        // 第五种：  获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
        return a;
    }
}
