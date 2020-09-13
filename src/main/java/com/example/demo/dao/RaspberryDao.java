package com.example.demo.dao;

import com.example.demo.pojo.Raspberry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaspberryDao extends JpaRepository<Raspberry, Integer> {
    Raspberry findById(int id);
    Raspberry findByName(String name);
}