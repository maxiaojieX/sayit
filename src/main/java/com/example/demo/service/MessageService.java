package com.example.demo.service;

import com.example.demo.bean.Message;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface MessageService {

    List<Message> findAllByAid(Integer aid);

    void save(Message message);

    List<Message> findByAid(Integer aid);
}
