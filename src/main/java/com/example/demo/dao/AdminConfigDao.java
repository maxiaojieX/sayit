package com.example.demo.dao;

import com.example.demo.bean.AdminConfig;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/13.
 */
public interface AdminConfigDao {

    List<AdminConfig> findAll();

    AdminConfig findByAdminId(Integer id);

}
