package com.example.demo.service;

import com.example.demo.bean.AdminConfig;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/17.
 */
public interface AdminConfigService {

    AdminConfig findById(Integer adminId);

    void save(AdminConfig adminConfig);

    void update(AdminConfig adminConfig);

}
