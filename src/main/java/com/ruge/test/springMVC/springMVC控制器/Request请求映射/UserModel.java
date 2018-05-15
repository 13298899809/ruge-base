package com.ruge.test.springMVC.springMVC控制器.Request请求映射;

import lombok.Data;

/**
 * @author 爱丽丝、如歌
 * @Description: requestPOJO 的实体类
 * @date 2018/5/9 11:37
 */
@Data
public class UserModel {
    private String id;
    private String name;
    private String age;
    private SchoolModel schoolModel;
}
