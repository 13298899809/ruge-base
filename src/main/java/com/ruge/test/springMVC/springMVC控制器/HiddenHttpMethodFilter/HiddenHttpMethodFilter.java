package com.ruge.test.springMVC.springMVC控制器.HiddenHttpMethodFilter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-08  22:12
 * 描述 ：HiddenHttpMethodFilter
 */
@Controller
@RequestMapping(value = "springmvc")
public class HiddenHttpMethodFilter {
    @RequestMapping(value = "HiddenHttpMethodFilter.do")
    public String init() {
        return "HiddenHttpMethodFilter";
    }

    /**
     * restful风格接口
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "filterGet/{id}", method = RequestMethod.GET)
    public String filterGet(@PathVariable Integer id) {
        System.out.println("filterGet===" + id);
        return "helloWorld";
    }

    /**
     * restful风格接口
     *
     * @return 返回页面
     */
    @RequestMapping(value = "filterPost", method = RequestMethod.POST)
    @ResponseBody
    public String filterPost() {
        System.out.println("filterPost===");
        return "helloWorld";
    }

    /**
     * restful风格接口
     *
     * @param id 参数
     * @return return “{msg:"hello noob!"}”
     */
    @RequestMapping(value = {"filterPut/{id}"}, method = RequestMethod.PUT)
    @ResponseBody
    public String filterPut(@PathVariable Integer id) {
        System.out.println("filterPut===" + id);
        return "helloWorld";
    }

    /**
     * restful风格接口
     *
     * @param id 参数
     * @return return “{msg:"hello noob!"}”
     */
    @RequestMapping(value = "filterDelete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String filterDelete(@PathVariable Integer id) {
        System.out.println("filterDelete===" + id);
        return "helloWorld";
    }
}
