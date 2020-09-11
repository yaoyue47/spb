package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RaspberryLimited {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private Float temMax;
    private Float temMin;
    private Float humMax;
    private Float humMin;
    private Float phMax;
    private Float phMin;
    private Float sunMax;
    private Float sunmin;

    private Boolean switchs;

}
