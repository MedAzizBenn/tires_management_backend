package com.spring.pneu.Dao;

import com.spring.pneu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthenticationDao extends JpaRepository<User,Integer> {
    public List<User> findAll();
    Optional<User> findByUsername(String username);
    User save(User user);

}
