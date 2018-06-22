package com.ruge.test.commons.dbutils.QueryRunner;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 爱丽丝、如歌  创建于 2018/6/15 20:22
 * 说明:  用户model
 *          Entity JPA注解
 */
@Entity
@Table(name = "Sys_User")
public class SysUser {
    @Id
    @Column(name = "user_id")
    private int user_Id;
    @Column(name = "user_Name")
    private String userName;
    @Column(name = "pass_Word")
    private String passWord;
    private String userMobile;
    private String userStatus;
    private String userEmail;
    private String userBirthday;
    private String userSex;
    private String userMotto;

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "user_Id=" + user_Id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userMotto='" + userMotto + '\'' +
                '}';
    }
}
