package com.ruge.test.commons.dbutils.QueryRunner;

import lombok.Data;

/**
 * 爱丽丝、如歌  创建于 2018/6/15 20:22
 * 说明:  用户model
 */
@Data
public class SysUser {
private  int user_Id;
private String userName;
private String passWord;
private String userMobile;
private String userStatus;
private String userEmail;
private String userBirthday;
private String userSex;
private String userMotto;
}
