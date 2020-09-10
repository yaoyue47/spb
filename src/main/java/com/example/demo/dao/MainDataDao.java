package com.example.demo.dao;

import com.example.demo.pojo.MainData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainDataDao extends JpaRepository<MainData, Integer> {
    MainData findById(int id);
}
