package com.ruge.test.spring.jdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-06  18:44
 * 描述 ：
 */
public class Test {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.setId(100);
        JDBCTest test = new JDBCTest();
        List<Map<String, Object>> maps = test.queryForList1(admin);
        List<Admin> admins = test.queryForList2(admin);
        System.out.println(maps+"==="+admins);
        for(Map attribute : maps) {
            System.out.println(attribute);
        }
        System.out.println("--------------------------");
        for (int i = 0; i <admins.size() ; i++) {
            int id = (int) maps.get(i).get("id");
            if(5==id){
                admins.get(i).setId(999);
            }

            for(Admin attribute : admins) {
                System.out.println(attribute);
            }
        }
    }
}
