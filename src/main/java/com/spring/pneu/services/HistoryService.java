package com.spring.pneu.services;

import com.spring.pneu.entity.History;
import com.spring.pneu.entity.User;

import java.util.List;

public interface HistoryService {
    public List<History> getUserHistory(int id);
    public List<User> getAllUsers();
    public User save(User user) throws Exception;
    public void addInsertHistory(int userId,String matricule);
    public void addUpdateHistory(int userId,String matricule);
    public void addDeleteHistory(int userId,String matricule);

}
