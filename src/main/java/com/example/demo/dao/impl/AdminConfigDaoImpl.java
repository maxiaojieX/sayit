package com.example.demo.dao.impl;

import com.example.demo.bean.AdminConfig;
import com.example.demo.dao.AdminConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/13.
 */
@Service
public class AdminConfigDaoImpl implements AdminConfigDao {


    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AdminConfig> findAll() {
        String sql="select * from admin_config";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper(AdminConfig.class));
    }

    @Override
    public AdminConfig findByAdminId(Integer id) {
        String sql = "select * from admin_config where admin_id=?";
        List<AdminConfig> adminConfigs = jdbcTemplate.query(sql,new Object[]{id},new BeanPropertyRowMapper<AdminConfig>(AdminConfig.class));
        if(adminConfigs!= null &&adminConfigs.size()!=0) {
            return adminConfigs.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void save(AdminConfig adminConfig) {
        String sql = "insert into admin_config (admin_id,autograph,head_portrait_url,sex,welcoming,email,nick_name) VALUES (10,'sfa','url',0,'hello','@qq.com','昵称');";
        jdbcTemplate.update(sql,new Object[]{adminConfig.getAdminId(),adminConfig.getAutograph(),adminConfig.getHeadPortraitUrl(),adminConfig.getSex(),adminConfig.getWelcoming(),adminConfig.getEmail(),adminConfig.getNickName()});
    }

    @Override
    public void update(AdminConfig adminConfig) {
        AdminConfig adminConfig2 =findByAdminId(adminConfig.getAdminId());
        if(adminConfig.getNickName()!= null) {
            adminConfig2.setNickName(adminConfig.getNickName());
        }
        if(adminConfig.getHeadPortraitUrl() != null) {
            adminConfig2.setHeadPortraitUrl(adminConfig.getHeadPortraitUrl());
        }
        if(adminConfig.getEmail() != null) {
            adminConfig2.setEmail(adminConfig.getEmail());
        }
        if(adminConfig.getWelcoming() != null) {
            adminConfig2.setWelcoming(adminConfig.getWelcoming());
        }
        if(adminConfig.getSex() != null) {
            adminConfig2.setSex(adminConfig.getSex());
        }
        if(adminConfig.getAutograph() != null) {
            adminConfig2.setAutograph(adminConfig.getAutograph());
        }
        String sql = "UPDATE admin_config SET autograph =?,head_portrait_url=?,sex=?,welcoming=?,email=?,nick_name=? WHERE admin_id=?";
        jdbcTemplate.update(sql,new Object[]{adminConfig2.getAutograph(),adminConfig2.getHeadPortraitUrl(),adminConfig2.getSex(),adminConfig2.getWelcoming(),adminConfig2.getEmail(),adminConfig2.getNickName(),adminConfig2.getAdminId()});
    }
}
