package com.example.demo.pojo;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String username;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Raspberry> raspberryList;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private RaspberryLimited raspberryLimitedList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
