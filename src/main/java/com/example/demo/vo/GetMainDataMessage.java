package com.example.demo.vo;

import lombok.Data;

@Data
public class GetMainDataMessage {
    private int id;
    private String time;
    private float temperature;
    private float humidity;
    private float ph;
    private float sun;
}
