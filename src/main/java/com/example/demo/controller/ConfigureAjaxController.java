package com.example.demo.controller;

import com.example.demo.service.RaspberryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ConfigureAjaxController {
    @Autowired
    RaspberryServiceImpl raspberryServiceImpl;

    @PostMapping("/api/configure/raspberry")
    public String insertRaspberry(@RequestBody Map<String, String> data) {
        String user = data.get("user");
        String name = data.get("name");
        String remark = data.get("remarks");

        if(raspberryServiceImpl.insertRaspberry(user, name, remark)){
            return "1";
        }else {
            return "0";
        }

    }
    @DeleteMapping("/api/configure/raspberry")
    public String deleteRaspberry(@RequestBody Map<String, Integer> data){
        int id = data.get("id");
        if(raspberryServiceImpl.deleteRaspberry(id)){
            return "1";
        }else {
            return "0";
        }

    }
    @PutMapping("/api/configure/raspberry")
    public String putRaspberry(@RequestBody Map data){
        int id = (int) data.get("id");
        String remarks = (String) data.get("remarks");
        if(raspberryServiceImpl.updateRaspberry(id,remarks)){
            return "1";
        }else {
            return "0";
        }
    }
}
