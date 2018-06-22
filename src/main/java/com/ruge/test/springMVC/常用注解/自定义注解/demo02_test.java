package com.ruge.test.springMVC.常用注解.自定义注解;

import javafx.scene.control.Tab;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 爱丽丝、如歌  创建于 2018/6/21 19:31
 * 说明:  TODO
 */
public class demo02_test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        demo02_bean bean1 = new demo02_bean();
        demo02_bean bean2 = new demo02_bean();
        bean1.setId("1");
        bean2.setName("刘");
        String sql1 = query(bean1);
        System.out.println("sql1"+sql1);
        String sql2 = query(bean2);
        System.out.println("sql2"+sql2);

    }

    private static String query(demo02_bean bean) {
           StringBuffer sb = new StringBuffer();
       try{
           /**
            * 1 获取到class
            */
           Class aClass = bean.getClass();
           /**
            * 2 获取table的名字
            */
           boolean b = aClass.isAnnotationPresent(TableName.class);
           if (!b) {
               return null;
           }
           TableName table = (TableName) aClass.getAnnotation(TableName.class);
           String value = table.value();
           sb.append("select * from ").append(value).append(" where 1=1");
           /**
            * 3 遍历所有的字段
            */
           Field[] fields = aClass.getDeclaredFields();
           for (Field f:fields
                   ) {
               boolean b1 = f.isAnnotationPresent(ColumnName.class);
               if (!b1) {
                   continue;
               }
               ColumnName name = f.getAnnotation(ColumnName.class);
               String columnValue =  name.value();
               /**
                * 拿到字段的名字
                */
               String fieldName =f.getName();
               String getNethod = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
               Method method = aClass.getMethod(getNethod);
               String fieldValue   = (String) method.invoke(bean, null);
               sb.append(" and ").append(fieldName).append(" = ").append(fieldValue);
           }
       }catch (Exception e){
           e.printStackTrace();
       }

        return sb.toString();
    }
}
