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
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<AdminConfig>(AdminConfig.class));
    }
}
