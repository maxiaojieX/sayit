package com.example.demo.dao;

import com.example.demo.bean.Admin;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface AdminDao {

    Admin findByUserName(String username);

    Integer save(String user,String password);

    List<Admin> findAll();
}
