package com.example.demo.dao.impl;

import com.example.demo.bean.Message;
import com.example.demo.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xiaojie.Ma on 2018/3/19.
 */
@Component
public class MessageDaoImpl implements MessageDao {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Message> findMine(Integer aid) {
        String sql = "SELECT aid,content,create_time,level,nick_name,sex FROM message INNER JOIN admin ON message.by=admin.id WHERE aid=? ORDER BY create_time DESC";
        return jdbcTemplate.query(sql,new Object[]{aid},new BeanPropertyRowMapper(Message.class));
    }

    @Override
    public void saveMessage(Message message) {
        String sql = "INSERT INTO message (aid,content,create_time,hide,each_other,message.by) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{message.getAid(),message.getContent(),message.getCreateTime(),message.getHide(),message.getEachOther(),message.getBy()});
    }

    @Override
    public List<Message> findByAdi(Integer aid) {
//        TODO 只查询未隐藏的
        String sql = "SELECT aid,content,create_time,level,nick_name,sex FROM message INNER JOIN admin ON message.by=admin.id WHERE aid=? ORDER BY create_time DESC";
        return jdbcTemplate.query(sql,new Object[]{aid},new BeanPropertyRowMapper(Message.class));
    }


}
