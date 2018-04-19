package com.example.demo.dao.impl;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Friends;
import com.example.demo.dao.FriendsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xiaojie.Ma on 2018/3/19.
 */
@Component
public class FriendsDaoImpl implements FriendsDao {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Friends> findByAid(Integer aid) {
        String sql = "SELECT bid,nick_name,autograph FROM admin_config INNER JOIN friends ON admin_config.admin_id = bid WHERE aid=?";
        return jdbcTemplate.query(sql,new Object[]{aid},new BeanPropertyRowMapper(Friends.class));
    }

    @Override
    public Admin findByName(String name) {
        String sql = "SELECT * FROM admin WHERE user = ?";
        Admin admin;
        try {
            admin = jdbcTemplate.queryForObject(sql,new Object[]{name},new BeanPropertyRowMapper<Admin>(Admin.class));
        }catch (EmptyResultDataAccessException e){
            admin = null;
        }
        return admin;
    }

    @Override
    public void save(Integer aid,Integer bid) {
        String  sql = "INSERT INTO friends (aid,bid) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[]{aid,bid});
    }


}
