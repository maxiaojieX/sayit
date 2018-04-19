package com.example.demo.controller;

import com.example.demo.bean.Admin;
import com.example.demo.bean.AdminConfig;
import com.example.demo.service.AdminConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/17.
 */
@Controller
public class UserConfigController {

    @Autowired
    private AdminConfigService adminConfigService;
    @RequestMapping("/saveConfig")
    @ResponseBody
    public String saveConfig(AdminConfig adminConfig, HttpServletRequest request) {
        if(adminConfig != null) {
            HttpSession session = request.getSession();
            Admin admin = (Admin) session.getAttribute("user");
            adminConfig.setAdminId(admin.getId());
            adminConfigService.update(adminConfig);
            return "SUCCESS";
        }else {
            return "ERROR";
        }

    }

}
