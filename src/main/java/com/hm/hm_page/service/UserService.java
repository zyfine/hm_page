package com.hm.hm_page.service;

import com.hm.hm_page.entity.User;
import com.hm.hm_page.entity.UserExample;
import com.hm.hm_page.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getFirst(int id) throws Exception {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);
        return userMapper.selectByExample(example).get(0);
    }

    public List<User> getAlluser() throws Exception {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    public void delUser(int id) throws Exception {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);
        userMapper.deleteByExample(example);
    }
    @Transactional
    public void insertUser(User record) throws Exception {
        userMapper.insert(record);
//        userMapper.insert(record);
    }

    public void insertUserBatch(List<User> list){
        userMapper.insertUserBatch(list);
    }

}