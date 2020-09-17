package com.example.demo.service;

import com.example.demo.dao.SystemInfoDao;
import com.example.demo.pojo.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickServiceImpl implements ClickService{
    @Autowired
    SystemInfoDao systemInfoDao;

    @Override
    public void increase() {
        SystemInfo byId = systemInfoDao.findById(1);
        if (byId ==null){
            SystemInfo systemInfo = new SystemInfo();
            systemInfo.setClickTime(1);
            systemInfoDao.save(systemInfo);
        }else {
            int click = byId.getClickTime();
            byId.setClickTime(click+1);
            systemInfoDao.save(byId);

        }

    }

    @Override
    public int getClick() {
        return systemInfoDao.findById(1).getClickTime();
    }
}
