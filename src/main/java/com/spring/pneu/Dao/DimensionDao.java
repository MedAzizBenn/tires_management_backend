package com.spring.pneu.Dao;

import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.Tire;
import com.spring.pneu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DimensionDao extends JpaRepository<Dimension,Integer> {
    public List<Dimension> findAll();

}
