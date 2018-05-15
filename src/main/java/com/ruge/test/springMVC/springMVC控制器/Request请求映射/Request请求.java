package com.ruge.test.springMVC.springMVC控制器.Request请求映射;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author 爱丽丝、如歌
 * @Description: TODO
 * @date 2018/5/9 11:08
 */
@Controller
@RequestMapping(value = "springmvc")
public class Request请求 {
    @RequestMapping(value = "requestInit.do", method = RequestMethod.GET)
    public String init() {
        return "Request请求";
    }

    /**
     * name 参数名字，即入参的请求参数名字，如username表示请求的参数区中的名字为username的参数的值将传入；
     * required 是否必须，默认是true，表示请求中一定要有相应的参数，否则将报404错误码
     * defaultValue 默认值
     */
    @RequestMapping(value = "requestParam.do")
    public String RequestParam请求映射(@RequestParam(name = "id", required = true, defaultValue = "1") String id,
                                   @RequestParam(name = "name", required = false, defaultValue = "张三") String name) {
        System.out.println("RequestParam请求映射 id:" + id + "name:" + name);
        return "helloWorld";
    }

    /**
     * 获取浏览器头信息
     * Content-Language: zh-CN
     * Content-Length: 92
     * Content-Type: text/html;charset=UTF-8
     * Date: Wed, 09 May 2018 03:05:30 GMT
     */
    @RequestMapping(value = "requestHeader.do")
    public String RequestHeader请求映射(@RequestHeader(value = "User-Agent") String cookie) {
        System.out.println("RequestHeader请求映射:" + cookie);
        return "helloWorld";
    }

    /**
     * requestCookieValue
     *
     * @param sessionId
     * @return
     */
    @RequestMapping(value = "requestCookieValue.do")
    public String RequestCookieValue请求映射(@CookieValue(value = "JSESSIONID", required = false) String sessionId) {
        System.out.println("RequestCookieValue请求映射:" + sessionId);
        return "helloWorld";
    }

    @RequestMapping(value = "requestPOJO.do", method = RequestMethod.POST)
    public String RequestPOJO请求映射(UserModel model) {
        System.out.println("UserModel:" + model);
        return "helloWorld";
    }

    @RequestMapping(value = "requestServletApi.do", method = RequestMethod.GET)
    public String requestServletApi请求映射(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request:"+request+"response:"+response);
        List client = new ArrayList();
        /**
         * 1.获得客户机信息
         */
        Enumeration<String> attributeNames = request.getAttributeNames();// 返回当前请求的所有属性的名字集合
        Object userName = request.getAttribute("userName");  //返回name指定的属性值
        Cookie[] cookies = request.getCookies();  //返回客户端发送的Cookie
        HttpSession session = request.getSession();  //返回客户端发送的Cookie
        HttpSession session1 = request.getSession(true);//返回和客户端相关的session，如果没有给客户端分配session，则创建一个session并返回
        HttpSession session2 = request.getSession(false);//返回和客户端相关的session，如果没有给客户端分配session，则创建一个session并返回
        String userName1 = request.getParameter("userName");//获取请求中的参数，该参数是由name指定的
        String[] userNames = request.getParameterValues("userName");  //返回请求中的参数值，该参数值是由name指定的
        String characterEncoding = request.getCharacterEncoding();  //返回请求的字符编码方式
        int contentLength = request.getContentLength(); //	返回请求体的有效长度
        String method = request.getMethod();//得到请求URL地址时使用的方法
        Enumeration<String> parameterNames = request.getParameterNames(); //获取请求中所有参数的名字
        String protocol = request.getProtocol(); //获取请求所使用的协议名称
        String remoteAddr = request.getRemoteAddr();//来访者的IP地址
        int remotePort = request.getRemotePort(); //使用的端口号
        String remoteHost = request.getRemoteHost();//来访者的主机名
        String serverName = request.getServerName(); //返回接受请求的服务器的名字
        String requestUrl = request.getRequestURL().toString();//请求的URL地址
        String requestUri = request.getRequestURI();//请求的资源
        String queryString = request.getQueryString();//请求的URL地址中附带的参数
        String remoteUser = request.getRemoteUser();
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名
        return "helloWorld";
    }
}
