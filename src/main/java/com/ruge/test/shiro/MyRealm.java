package com.ruge.test.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 爱丽丝、如歌  创建于 2018/5/25 11:24
 * 说明:  自定义realm
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        System.out.println("=========getName()===========");
        return "myrealm";
    }

    /**
     * 授权操作
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("============principalCollection=====================");
        return null;
    }

    /**
     * 认证操作
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();  //得到用户名
        String password = new String((char[]) token.getCredentials()); //得到密码
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
