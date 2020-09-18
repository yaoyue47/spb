package com.example.demo.service;

import com.example.demo.pojo.Raspberry;

import java.util.List;

public interface RaspberryService {
    List<String> getList(String user);
    List<Raspberry> getRaspberryList(String user);
    boolean insertRaspberry(String user,String name,String remarks);
    boolean deleteRaspberry(int id);
    boolean updateRaspberry(int id,String remarks);
}
