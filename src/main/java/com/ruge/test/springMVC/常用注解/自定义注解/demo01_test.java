package com.ruge.test.springMVC.常用注解.自定义注解;

/**
 * 爱丽丝、如歌  创建于 2018/6/21 18:41
 * 说明:  TODO
 */
@demo01_自定义注解(
        author = "张三",
        date = "2018年6月21日18:42:33",
        revire = {"张三","李四","王五"},
        value = "测试自定义注解"
)
public class demo01_test {
    public static void main(String[] args) {
        Class<demo01_自定义注解> aClass = demo01_自定义注解.class;
        demo01_自定义注解 annotation = aClass.getAnnotation(demo01_自定义注解.class);
        System.out.println(annotation.author());
    }
}
