package com.example.demo.service;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Friends;

import java.util.List;

/**
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface FrinedsService {

    List<Friends> findAll(Integer aid);

    Admin findByName(String name);

    void save(Integer aid,Integer bid);
}
