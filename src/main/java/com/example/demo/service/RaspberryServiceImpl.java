package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Raspberry;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RaspberryServiceImpl implements RaspberryService {

    @Autowired
    UserDao userDao;

    @Override
    public List<String> getList(String user) {
        User byUsername = userDao.findByUsername(user);
        List<Raspberry> raspberryList = byUsername.getRaspberryList();
        List<String> list = new ArrayList<String>();
        for (Raspberry i:raspberryList){
            list.add(i.getName());
        }
        return list;

    }
}
