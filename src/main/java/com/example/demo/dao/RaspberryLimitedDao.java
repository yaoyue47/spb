package com.example.demo.dao;

import com.example.demo.pojo.RaspberryLimited;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaspberryLimitedDao extends JpaRepository<RaspberryLimited, Integer> {
    RaspberryLimited findById(int id);
}
