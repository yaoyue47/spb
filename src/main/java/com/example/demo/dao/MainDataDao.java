package com.example.demo.dao;

import com.example.demo.pojo.MainData;
import com.example.demo.pojo.Raspberry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainDataDao extends JpaRepository<MainData, Integer> {
    MainData findById(int id);

    Page<MainData> findAllByRaspberry(Pageable pageable, Raspberry raspberry);
}
