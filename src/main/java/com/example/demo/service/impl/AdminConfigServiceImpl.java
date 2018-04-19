package com.example.demo.service.impl;

import com.example.demo.bean.AdminConfig;
import com.example.demo.dao.AdminConfigDao;
import com.example.demo.dao.AdminDao;
import com.example.demo.service.AdminConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/17.
 */
@Service
public class AdminConfigServiceImpl implements AdminConfigService {
    @Autowired
    private AdminConfigDao adminConfigDao;
    @Override
    public AdminConfig findById(Integer adminId) {
        return adminConfigDao.findByAdminId(adminId);
    }

    @Override
    public void save(AdminConfig adminConfig) {
        adminConfigDao.save(adminConfig);
    }

    @Override
    public void update(AdminConfig adminConfig) {
        adminConfigDao.update(adminConfig);
    }
}
