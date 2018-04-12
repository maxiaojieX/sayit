package com.example.demo.dao.impl;

import com.example.demo.bean.Admin;
import com.example.demo.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
        Admin admin;
        try{
            admin =jdbcTemplate.queryForObject(sql,new Object[]{username},new BeanPropertyRowMapper<Admin>(Admin.class));
        }catch (EmptyResultDataAccessException e){
            admin = null;
        }
        return admin;
    }

    @Override
    public void save(String user, String password,String nickName, String email) {
        String sql = "INSERT INTO admin (user,password,nick_name,other) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{user,password,nickName,email});
    }
}
