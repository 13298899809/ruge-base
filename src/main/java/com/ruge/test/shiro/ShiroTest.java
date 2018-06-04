package com.ruge.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/5/25 9:21
 * 说明:  shiro测试
 */
public class ShiroTest {
    @Test
    public void testLogin() {
        /**
         * 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:test/shiro/shiro.ini");
        /**
         * 2、得到SecurityManager实例 并绑定给SecurityUtils
         */
        SecurityManager securityManager = factory.getInstance();
        /**
         * 3、将securityManager绑定到当前运行环境中
         */
        SecurityUtils.setSecurityManager(securityManager);
        /**
         * 4、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
         */
        Subject subject = SecurityUtils.getSubject();
        /**
         * 5、当前用户登录凭证
         */
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        //6、登录，即身份验证
        try {
            subject.login(token);
        } catch (LockedAccountException e) {
            System.out.println("用户登录-锁定的帐号" + e);
        } catch (DisabledAccountException e) {
            System.out.println("用户登录-禁用的帐号" + e);
        } catch (UnknownAccountException e) {
            System.out.println("用户登录-错误的帐号" + e);
        } catch (ExcessiveAttemptsException e) {
            System.out.println("用户登录-失败次数过多的帐号" + e);
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户登录-错误的凭证" + e);
        } catch (ExpiredCredentialsException e) {
            System.out.println("用户登录-过期的凭证" + e);
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        System.out.println("用户登录" + subject.isAuthenticated());
        //7、登出
        subject.logout();
        System.out.println("用户登录" + subject.isAuthenticated());
    }

    @Test
    public void testLoginByRealm() {
        /**
         * 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:test/shiro/shiro-realm.ini");
        /**
         * 2、得到SecurityManager实例 并绑定给SecurityUtils
         */
        SecurityManager securityManager = factory.getInstance();
        /**
         * 3、将securityManager绑定到当前运行环境中
         */
        SecurityUtils.setSecurityManager(securityManager);
        /**
         * 4、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
         */
        Subject subject = SecurityUtils.getSubject();
        /**
         * 5、当前用户登录凭证
         */
        String username = "zhang";
        String password = "123";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //6、登录，即身份验证
        subject.login(token);
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        System.out.println("用户登录" + subject.isAuthenticated());
        //7、登出
        subject.logout();
        System.out.println("用户登录" + subject.isAuthenticated());
    }

    @Test
    public void testLoginByPasswordRealm() {
        /**
         * 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:test/shiro/shiro-password-realm.ini");
        /**
         * 2、得到SecurityManager实例 并绑定给SecurityUtils
         */
        SecurityManager securityManager = factory.getInstance();
        /**
         * 3、将securityManager绑定到当前运行环境中
         */
        SecurityUtils.setSecurityManager(securityManager);
        /**
         * 4、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
         */
        Subject subject = SecurityUtils.getSubject();
        /**
         * 5、当前用户登录凭证
         */
        String username = "zhang";
        String password = "123";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //6、登录，即身份验证
        subject.login(token);
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        System.out.println("用户登录" + subject.isAuthenticated());
        //7、登出
        subject.logout();
        System.out.println("用户登录" + subject.isAuthenticated());
    }

    @Test
    public void testLoginByRolePermissionRealm() {
        /**
         * 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:test/shiro/shiro-permission.ini");
        /**
         * 2、得到SecurityManager实例 并绑定给SecurityUtils
         */
        SecurityManager securityManager = factory.getInstance();
        /**
         * 3、将securityManager绑定到当前运行环境中
         */
        SecurityUtils.setSecurityManager(securityManager);
        /**
         * 4、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
         */
        Subject subject = SecurityUtils.getSubject();
        /**
         * 5、当前用户登录凭证
         */
        String username = "wang";
        String password = "123";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //6、登录，即身份验证
        subject.login(token);
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        boolean authenticated = subject.isAuthenticated();
        System.out.println("用户登录" + (authenticated ? "成功" : "失败"));
        boolean role = subject.hasRole("role1");
        boolean[] role1 = subject.hasRoles(Arrays.asList("role1", "role2"));
        System.out.println("用户是否拥有role1角色:" + role);
        System.out.println("用户是否拥有role1角色:" + role1[0] + "-" + role1[1]);
        /**
         * 返回true是否Subject允许执行操作或访问由指定Permission实例汇总的资源，false否则返回。
         */
        boolean permitted = subject.isPermitted("user:create");
        /**
         * 返回true是否Subject允许所有指定的权限，false否则返回。
         */
        permitted = subject.isPermittedAll("user:create", "user:update");
        System.out.println("当前用户" + permitted + "拥有user:create的权限");
        subject.isPermitted();
        //7、登出
        subject.logout();
    }


    @Test
    public void testHasRoleRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:test/shiro/shiro-permission-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        String username = "wang";
        String password = "123";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        boolean authenticated = subject.isAuthenticated();
        System.out.println("用户登录" + (authenticated ? "成功" : "失败"));
        boolean role = subject.hasRole("role1");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("user:create");
     //   stringBuffer.append("user:update");
        boolean permitted = subject.isPermitted(stringBuffer.toString());
        System.out.println(role);
        System.out.println(permitted);

        subject.logout();
    }
    @Test
    public void test(){
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        a=a+1;
        System.out.println(a);
    }
}
