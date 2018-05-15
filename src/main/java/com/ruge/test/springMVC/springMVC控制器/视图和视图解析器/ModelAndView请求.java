package com.ruge.test.springMVC.springMVC控制器.视图和视图解析器;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author 爱丽丝、如歌
 * @SessionAttributes({"user"}) 增加该标签   在session域中就能查询到数据了
 * @date 2018/5/9 13:32
 */
@SessionAttributes({"user"})
@Controller
@RequestMapping(value = "springmvc", method = RequestMethod.GET)
public class ModelAndView请求 {
    @RequestMapping(value = "MVCInit.do", method = RequestMethod.GET)
    public String MVCInit() {
        return "视图和视图解析器/init";
    }

    @RequestMapping(value = "testModelAndView.do")
    public ModelAndView modelAndView() {
        String viewName = "视图和视图解析器/ModelAndView请求";
        ModelAndView view = new ModelAndView();
        view.setViewName(viewName);
        view.addObject("time", new Date());
        UserModel model = new UserModel();
        List list = new ArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        view.addObject("list", list);
        List<UserModel> modelList = new ArrayList<>();
        model.setId("1");
        model.setName("张三");
        model.setAge("19");
        modelList.add(model);
        view.addObject("modelList", modelList);
        Map map = new HashMap();
        map.put("now", new Date());
        map.put("list", list);
        map.put("modelList", modelList);
        view.addObject("map", map);
        return view;
    }

    @RequestMapping(value = "testSessionAttribute.do")
    public String testSessionAttribute(Map<String, Object> map) {

        UserModel model = new UserModel();
        model.setId("1");
        model.setAge("18");
        model.setName("刘德华");
        map.put("user", model);
        return "视图和视图解析器/ModelAndView请求";
    }

    /*这样直接获取会将年龄像弄成空   不符合我们的需求 所以我们使用*/
    @RequestMapping(value = "testModelAttribute", method = RequestMethod.POST)
    public String testModelAttribute(UserModel model) {
        System.out.println("修改的数据为:" + model);
        return "视图和视图解析器/ModelAndView请求";
    }

    /**
     * 执行ModelAndView请求Controller内带有@RequestMapping的方法之前,都会先执行此getUser方法
     *
     * @param model
     */
    @ModelAttribute
    public void getUser(UserModel model) {
        if (model.getId() != null) {
            /**
             * 模拟数据库数据的读取
             */
            model.setId("1");
            model.setName("张学友");
            model.setAge("23");
            System.out.println("模拟从数据库中获取的:" + model);
        }
    }

    /**
     *  重定向
     *  应用场景 登出
     *  return "rediret:/index.jsp"; 失败了
     */
    @RequestMapping(value = "testRedirect.do", method = RequestMethod.GET)
    public String testRedirect() {

        return "redirect:/index.jsp";
    }

    /**
     *  转发 在服务器端完成的
     *  应用场景:登录
     *  return "forward:/index.jsp"; 成功了
     */
    @RequestMapping(value = "testForward.do", method = RequestMethod.GET)
    public String testForward() {
        return "forward:/index.jsp";
    }

}
