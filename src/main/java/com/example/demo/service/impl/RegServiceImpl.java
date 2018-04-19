package com.example.demo.service.impl;

import com.example.demo.bean.AdminConfig;
import com.example.demo.dao.AdminConfigDao;
import com.example.demo.dao.AdminDao;
import com.example.demo.service.RegService;
import com.example.demo.util.GetAccountNumberUtil;
import com.ma.send.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaojie.Ma on 2018/3/20.
 */
@Service
public class RegServiceImpl implements RegService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminConfigDao adminConfigDao;
    @Override
    public String doReg(String email, String password,String nickName) {
        String user = GetAccountNumberUtil.getAccountNum();
        Integer id = adminDao.save(user,password);
        AdminConfig adminConfig = new AdminConfig();
        adminConfig.setAdminId(id);
        adminConfig.setEmail(email);
        adminConfig.setNickName(nickName);
        adminConfigDao.save(adminConfig);
        return user;
    }
}
