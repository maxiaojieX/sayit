package com.example.demo.service.impl;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Friends;
import com.example.demo.dao.FriendsDao;
import com.example.demo.service.FrinedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaojie.Ma on 2018/3/19.
 */
@Service
public class FriendsServiceImpl implements FrinedsService {
    @Autowired
    private FriendsDao friendsDao;
    @Override
    public List<Friends> findAll(Integer aid) {
        return friendsDao.findByAid(aid);
    }

    @Override
    public Admin findByName(String name) {
        return friendsDao.findByName(name);
    }

    @Override
    public void save(Integer aid, Integer bid) {
        friendsDao.save(aid,bid);
    }
}
