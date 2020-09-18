package com.example.demo.service;

import com.example.demo.dao.RaspberryDao;
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

    @Autowired
    RaspberryDao raspberryDao;

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

    @Override
    public List<Raspberry> getRaspberryList(String user) {
        User byUsername = userDao.findByUsername(user);
        return byUsername.getRaspberryList();
    }

    @Override
    public boolean insertRaspberry(String user, String name, String remarks) {
        User byUsername = userDao.findByUsername(user);
        Raspberry raspberry = new Raspberry();
        raspberry.setUser(byUsername);
        raspberry.setName(name);
        raspberry.setRemarks(remarks);
        try {
            raspberryDao.save(raspberry);
            return true;
        }catch (RuntimeException e){
            return false;
        }

    }

    @Override
    public boolean deleteRaspberry(int id) {
        try {
            raspberryDao.deleteById(id);
            return true;
        }catch (RuntimeException e){
            return false;
        }

    }

    @Override
    public boolean updateRaspberry(int id, String remarks) {
        try {
            Raspberry byId = raspberryDao.findById(id);
            byId.setRemarks(remarks);
            raspberryDao.save(byId);
            return true;
        }catch (RuntimeException e){
            return false;
        }

    }
}
