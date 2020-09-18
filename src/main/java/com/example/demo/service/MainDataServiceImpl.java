package com.example.demo.service;

import com.example.demo.dao.MainDataDao;
import com.example.demo.dao.RaspberryDao;
import com.example.demo.pojo.MainData;
import com.example.demo.pojo.Raspberry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class MainDataServiceImpl implements MainDataService{
    @Autowired
    RaspberryDao raspberryDao;
    @Autowired
    MainDataDao mainDataDao;

    @Override
    public boolean creatMainData() {
        return false;
    }

    @Override
    public List<MainData> getMainDataExcel(int page, String raspberry) {
        Raspberry byName = raspberryDao.findByName(raspberry);
        Sort sort =Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page, 6, sort);
        Page<MainData> allByRaspberry = mainDataDao.findAllByRaspberry(pageable, byName);
        return allByRaspberry.getContent();
    }

    @Override
    public void getMainDataEchart() {

    }
}
