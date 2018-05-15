package com.ruge.test.springMVC.RESTFulCRUD;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id,
                            Map<String, Object> map) {
        if (id != null) {
            map.put("employee", employeeDao.get(id));
        }
    }

    /**
     * 数据更新
     * @param employee 传入实体类的参数
     * @return 重定向到emps请求
     */
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     *
     * @param id  get请求的数据回显
     * @param map 返回参数
     * @return 跳转至from表单页面
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("employee", employeeDao.get(id));
        map.put("departments", departmentDao.getDepartments());
        return "RESTFulCRUD/form";
    }

    /**
     * 删除方法
     * @param id  delete方式  传入的参数 id
     * @return 重定向到emps请求
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /**
     * form表单的数据保存
     * @param employee 员工的实体类
     * @param result 错误信息
     * @param map 返回结果集
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Validated Employee employee, Errors result,
                       Map<String, Object> map) {
        System.out.println("save: " + employee);

        if (result.getErrorCount() > 0) {
            System.out.println("出错啦!");

            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }

            //若验证出错, 则转向定制的页面
            map.put("departments", departmentDao.getDepartments());
            return "input";
        }
        /**
         * 保存后重定向到emps请求
         */
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * get 跳转至新增页面
     * @param map 返回值
     * @return 返回页面
     */
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("departments", departmentDao.getDepartments());
        map.put("employee", new Employee());
        return "RESTFulCRUD/form";
    }

    /**
     * 查询所有数据的list集合
     * @param map
     * @return
     */
    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        map.put("employees", employeeDao.getAll());
        return "RESTFulCRUD/list";
    }
}
