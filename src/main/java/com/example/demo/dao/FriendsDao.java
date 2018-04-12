package com.example.demo.dao;

import com.example.demo.bean.Admin;
import com.example.demo.bean.Friends;

import java.util.List;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/19.
 */
public interface FriendsDao {

    List<Friends> findByAid(Integer aid);

    Admin findByName(String name);

    void save(Integer aid,Integer bid);
}
