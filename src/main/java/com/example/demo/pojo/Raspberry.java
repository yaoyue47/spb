package com.example.demo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Raspberry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String name;

    private String status;

    private String remarks;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "raspberry",cascade=CascadeType.ALL)
    private List<MainData> mainDataList;

    @Override
    public String toString() {
        return "Raspberry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", user=" + user +
                '}';
    }
}
