package com.example.demo.service;

import com.example.demo.dao.RaspberryDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Raspberry;
import com.example.demo.pojo.User;
import com.example.demo.utiliy.IsEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RaspberryDao raspberryDao;

    @Override
    public int create(Map<String, String> user) {
        if(!IsEmail.check(user.get("email"))){
            return 1;
        }
        if(userDao.findByUsername(user.get("user"))!=null){
            return 2;
        }
        if (raspberryDao.findByName(user.get("name"))!=null){
            return 3;
        }
        try {
            User user1 = new User();
            user1.setUsername(user.get("user"));
            user1.setPassword(user.get("pwd"));
            user1.setEmail(user.get("email"));
            User save = userDao.save(user1);

            Raspberry raspberry = new Raspberry();
            raspberry.setName(user.get("name"));
            raspberry.setUser(save);
            raspberryDao.save(raspberry);
            return 0;
        }catch (RuntimeException e){
            System.out.println(e);
         return 4;
        }
    }
}
