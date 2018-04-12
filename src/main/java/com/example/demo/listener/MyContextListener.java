package com.example.demo.listener;

import com.example.demo.filter.URLWhiteList;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/11.
 */
@Component
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        URLWhiteList.URLLIST.add("/");
        URLWhiteList.URLLIST.add("/login");
        URLWhiteList.URLLIST.add("/reg");
        URLWhiteList.URLLIST.add("/getCode");
        URLWhiteList.URLLIST.add("/error");
        URLWhiteList.URLLIST.add("/doReg");
        System.out.println("URL白名单已启用");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
