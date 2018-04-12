package com.example.demo.service.impl;

import com.example.demo.bean.Admin;
import com.example.demo.dao.AdminDao;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaojie.Ma on 2018/3/19.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findByName(String username) {
        return adminDao.findByUserName(username);
    }

    @Override
    public boolean chickAdmin(String username,String password,HttpServletRequest request) {
        Admin admin = adminDao.findByUserName(username);
        if(admin == null) {
            return false;
        }else if(password.equals(admin.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user",admin);
            return true;
        }else {
            return false;
        }
    }
}
