package com.ruge.test.springMVC.springMVC控制器.Request请求映射;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 爱丽丝、如歌
 * @Description: TODO
 * @date 2018/5/8 9:05
 */
@Controller
@RequestMapping(value = "springmvc")
public class ValueMethodParamsHeadersAnt属性 {
    /**
     * 跳转到valueMethodParamsHeaders的教程页面
     *
     * @return
     */
    @RequestMapping(value = "valueMethodParamsHeadersAnt.do", method = RequestMethod.GET)
    public String init() {
        return "ValueMethodParamsHeadersAnt属性";
    }

    /**
     * 测试get请求方式
     *
     * @return 返回页面
     */
    @RequestMapping(value = "get.do", method = RequestMethod.GET)
    public String testGet() {
        return "helloWorld";
    }

    /**
     * 测试post请方式
     *
     * @return 返回页面
     */
    @RequestMapping(value = "post.do", method = RequestMethod.POST)
    public String testPost() {
        return "helloWorld";
    }

    /**
     * 测试params请求   参数必须包含username age不能等于10
     * params 只是判断url 或者 form data 中的参数是否复合params的定义，并不会直接绑定数据到方法的参数中！
     *
     * @return 返回页面
     */
    @RequestMapping(value = "params.do", method = RequestMethod.GET, params = {"username", "age!=10"})
    public String testParams() {
        return "helloWorld";
    }

    /**
     * 测试headers 浏览器中的RequestHeaders的属性
     *
     * @return 返回页面
     */
    @RequestMapping(value = "headers.do", method = RequestMethod.GET, headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String testHeaders() {
        return "helloWorld";
    }

    /**
     * ant风格的url
     * ? 匹配任意单字符
     *
     * @return 返回页面
     */
    @RequestMapping(value = "ant1/?/aaa.do", method = RequestMethod.GET)
    public String testAnt单个字符() {
        return "helloWorld";
    }

    /**
     * ant风格的url
     * * 匹配0或多个任意数量的字符
     *
     * @return 返回页面
     */
    @RequestMapping(value = "ant2/*/aaa.do", method = RequestMethod.GET)
    public String testAnt任意字符() {
        return "helloWorld";
    }

    /**
     * ant风格的url
     * ** 匹配0或者更多目录
     *
     * @return 返回页面
     */
    @RequestMapping(value = "ant3/**/aaa.do", method = RequestMethod.GET)
    public String testAnt更多目录() {
        return "helloWorld";
    }

    /**
     * @param id PathVariable的参数
     * @return 返回页面
     * @PathVariable : 绑定路径中的占位符参数到方法参数变量中；
     */
    @RequestMapping(value = "testPathVariable/{id}.do", method = RequestMethod.GET)
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "helloWorld";
    }
}

