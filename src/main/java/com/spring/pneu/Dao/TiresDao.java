package com.spring.pneu.Dao;

import com.spring.pneu.entity.Tire;
import com.spring.pneu.entity.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TiresDao extends JpaRepository<Tire,Integer> {
    public List<Tire> findAll();
    public Tire findById(int id);
    public Tire save(Tire tire);
   // public void deleteBy(int id);


}