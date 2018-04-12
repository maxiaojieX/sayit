package com.example.demo.service.impl;

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
    @Override
    public String doReg(String email, String password,String nickName) {
        String user = GetAccountNumberUtil.getAccountNum();
        adminDao.save(user,password,nickName,email);
        return user;
    }
}
