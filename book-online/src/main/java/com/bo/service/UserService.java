package com.bo.service;

import com.bo.entity.User;

import java.util.List;

/**
 * @program: Java_Web-dev
 * @description:
 * @author: EthanJiao
 * @create: 2022-02-24
 **/

public class UserService {
    private List<User> userList;
    /**
     * 给用户列表变量传值
     */
    public void setUserList(List<User> userList){this.userList = userList;}


    /**
     * 用户登录
     */
    public User signIn(String account , String password){
        for (User user : userList){
            if(user.getAccount().equals(account) && user.getAccount().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new UserService().signIn("18012275669","111");
        if (user != null){
            System.out.println(user);
        }else {
            System.out.println("登录失败");
        }
    }
}

