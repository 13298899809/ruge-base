package com.ruge.test.springMVC.支持json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 爱丽丝、如歌
 * @Description: TODO
 * @date 2018/5/11 12:52
 */
@Controller
@RequestMapping(value = "springmvc")
public class JsonController {
    @RequestMapping(value = "jsonInit.do")
    public String init(){
        return "支持json/init";
    }
    @RequestMapping(value = "queryJson.do")
    @ResponseBody
    public Map query(){
        Map map = new HashMap();
        map.put("time",new Date());
        map.put("model",new JsonModel("1","张三"));
        map.put("list",Arrays.asList(new JsonModel("2","李四"),new JsonModel("3","王五")));
        return map;
    }
}
