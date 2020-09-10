package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserDao Userdao;
    @Autowired
    RaspberryDao RaspberryDao;
    @Autowired
    RaspberryLimitedDao RaspberryLimitedDao;
    @Autowired
    MainDataDao mainDataDao;
    @Autowired
    SystemInfoDao systemInfoDao;

    @Test
    void contextLoads() {
       /* User user = new User();
        user.setUsername("g7daa7");
        user.setPassword("2535777577773700");
        user.setEmail("awf");
        Userdao.save(user);*/

        User u = Userdao.findById(1);
        //System.out.println(u);
        Raspberry raspberry = new Raspberry();
        raspberry.setName("af77zszf");
        raspberry.setRemarks("00000014");
        raspberry.setUser(u);
       // u.getRaspberryList().add(raspberry);
        RaspberryDao.save(raspberry);



    }

    @Test
    void adw1() {
        System.out.println(RaspberryDao.findById(1).getUser());
        System.out.println(Userdao.findById(1).getRaspberryList());
    }

    @Test
    void adwad() {
        User user = Userdao.findById(11);
        RaspberryLimited raspberryLimited = new RaspberryLimited();
        raspberryLimited.setUser(user);
        raspberryLimited.setHumMax(12F);
        raspberryLimited.setPhMin(266F);
        //user.setRaspberryLimitedList(raspberryLimited);
        RaspberryLimitedDao.save(raspberryLimited);
    }
    @Test
    void wdaf(){
        User user = Userdao.findById(11);
        System.out.println(user.getRaspberryLimitedList());
    }
    @Test
    void adwafawf(){
        User user = Userdao.findById(3);
        System.out.println(user.getRaspberryList());
    }
    @Test
    void adwafawg(){
        Raspberry aawd = RaspberryDao.findById(2);
        System.out.println(aawd);
        LocalDateTime localDateTime=LocalDateTime.now();
        MainData mainData= new MainData();
        mainData.setHumidity(12f);
        mainData.setPh(158f);
        mainData.setLocalDateTime(localDateTime);
        mainDataDao.save(mainData);

    }
    @Test
    void adwafafvav(){
        System.out.println(RaspberryDao.findById(5).getUser());
    }
}
