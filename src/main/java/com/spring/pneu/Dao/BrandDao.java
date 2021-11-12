package com.spring.pneu.Dao;

import com.spring.pneu.entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDao extends JpaRepository<Marque, Integer> {
    public List<Marque> findAll();
    public Marque save(Marque marque);
}
