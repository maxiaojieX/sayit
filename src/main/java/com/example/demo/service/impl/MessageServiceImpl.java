package com.example.demo.service.impl;

import com.example.demo.bean.Message;
import com.example.demo.dao.MessageDao;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaojie.Ma on 2018/3/19.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Override
    public List<Message> findAllByAid(Integer aid) {
        return messageDao.findMine(aid);
    }

    @Override
    public void save(Message message) {
        messageDao.saveMessage(message);
    }

    @Override
    public List<Message> findByAid(Integer aid) {
        return messageDao.findByAdi(aid);
    }
}
