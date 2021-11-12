package com.spring.pneu.Dao;

import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsDao extends JpaRepository<client,Integer> {
    public List<client> findAll();

}