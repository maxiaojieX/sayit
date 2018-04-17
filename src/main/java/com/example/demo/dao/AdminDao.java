package com.example.demo.dao;

import com.example.demo.bean.Admin;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface AdminDao {

    Admin findByUserName(String username);

    void save(String user,String password,String nickName,String email);

    List<Admin> findAll();
}
