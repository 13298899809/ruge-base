package com.ruge.test.springMVC.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-07  21:58
 * 描述 ：helloWorld
 */
@Controller
public class HelloWorldController {
    @RequestMapping(value = "helloWorld.do",method = RequestMethod.GET)
    public  String helloWorld(){
        return "helloWorld";
    }

}
