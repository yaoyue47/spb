package com.example.demo.service;

import com.example.demo.pojo.MainData;

import java.util.List;

public interface MainDataService {
    boolean creatMainData();
    List<MainData> getMainDataExcel(int page,String raspberry);
    void getMainDataEchart();
}
