package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class MainData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float temperature;

    private float humidity;

    private float ph;

    private float sun;

    private LocalDateTime localDateTime;
    @ManyToOne(optional = false)
    @JoinColumn(name = "raspberry_id")
    //@Column(nullable = false)
    private Raspberry raspberry;
}
