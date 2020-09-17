package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class HomeMessage {
    private String user;
    private int clickTime;
    private List<String> raspberry;
    private String raspberryNow;
}
