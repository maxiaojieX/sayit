package com.example.demo.service;

import com.example.demo.bean.Admin;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface AdminService {

    Admin findByName(String username);

    boolean chickAdmin(String username,String password,HttpServletRequest request);
}
