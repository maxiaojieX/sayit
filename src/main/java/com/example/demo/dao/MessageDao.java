package com.example.demo.dao;

import com.example.demo.bean.Message;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface MessageDao {

    List<Message> findMine(Integer aid);

    void saveMessage(Message message);

    List<Message> findByAdi(Integer aid);

}
