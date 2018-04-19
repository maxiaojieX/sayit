package com.example.demo.dao.impl;

import com.example.demo.bean.Admin;
import com.example.demo.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
@Component
public class AdminDaoImpl implements AdminDao {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public Admin findByUserName(String username) {
        String sql = "SELECT * from admin where admin.user=?";
        List<Admin> admins = jdbcTemplate.query(sql,new Object[]{username},new BeanPropertyRowMapper(Admin.class));
        if(admins != null && admins.size() != 0) {
            return admins.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Integer save(String user, String password) {
        String sql = "INSERT INTO admin (user,password) VALUES (?,?)";
        if(jdbcTemplate.update(sql,new Object[]{user,password}) != 0){
            String sql2 = "select * from admin where admin.user=? and password=?";
            Admin admin = jdbcTemplate.queryForObject(sql2,new Object[]{user,password},new BeanPropertyRowMapper<Admin>(Admin.class));
            return admin.getId();
        }else {
            return -1;
        }

    }

    @Override
    public List<Admin> findAll() {
        String sql = "select * from admin";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper(Admin.class));
    }
}
