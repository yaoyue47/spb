package com.example.demo.dao;

import com.example.demo.pojo.SystemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemInfoDao extends JpaRepository<SystemInfo, Integer> {
    SystemInfo findById(int id);
}
