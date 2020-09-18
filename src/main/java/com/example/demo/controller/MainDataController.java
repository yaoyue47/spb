package com.example.demo.controller;

import com.example.demo.pojo.MainData;
import com.example.demo.service.MainDataServiceImpl;
import com.example.demo.vo.GetMainDataMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainDataController {
    @Autowired
    MainDataServiceImpl mainDataService;
    @GetMapping("/api/getExcelData")
    public List<GetMainDataMessage> getMainData(@RequestParam(value = "page") int page,@RequestParam(value = "raspberry") String raspberry){
        List<MainData> mainDataExcel = mainDataService.getMainDataExcel(page-1, raspberry);
        List<GetMainDataMessage> getMainDataMessages = new ArrayList();
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (MainData mainData:mainDataExcel){
            GetMainDataMessage getMainDataMessage = new GetMainDataMessage();
            getMainDataMessage.setId(mainData.getId());
            getMainDataMessage.setTime(mainData.getLocalDateTime().format(dateTimeFormatter));
            getMainDataMessage.setHumidity(mainData.getHumidity());
            getMainDataMessage.setTemperature(mainData.getTemperature());
            getMainDataMessage.setPh(mainData.getPh());
            getMainDataMessage.setSun(mainData.getSun());
            getMainDataMessages.add(getMainDataMessage);
        }
        return getMainDataMessages;
    }
}
