package com.spring.pneu.services;

import com.spring.pneu.Dao.AuthenticationDao;
import com.spring.pneu.Dao.HistoryDao;
import com.spring.pneu.entity.History;
import com.spring.pneu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service
public class HistoryServiceImp implements HistoryService{
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private AuthenticationDao usersDao;
    @Override
    public List<History> getUserHistory(int id) {
        return this.historyDao.findByUserId(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.usersDao.findAll();
    }

    @Override
    public User save(User user) throws Exception {
        if(this.usersDao.findByUsername(user.getUsername())!=null)
        {
            throw new Exception("Username already Exists!");
        }
        else
        {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            System.out.println("here "+encodedPassword);
            user.setPassword(encodedPassword);
            return this.usersDao.save(user);
        }



    }

    @Override
    @Transactional
    public void addInsertHistory(int userId,String matricule) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = localDateTime.toLocalTime();

        LocalDate localDate = localDateTime.toLocalDate();
        this.historyDao.saveInsert(userId,localDate.toString(),localTime.toString(),matricule);
    }
    @Override
    @Transactional
    public void addUpdateHistory(int userId,String matricule) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = localDateTime.toLocalTime();

        LocalDate localDate = localDateTime.toLocalDate();
        this.historyDao.saveUpdate(userId,localDate.toString(),localTime.toString(),matricule);
    }
    @Override
    @Transactional
    public void addDeleteHistory(int userId,String matricule) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = localDateTime.toLocalTime();

        LocalDate localDate = localDateTime.toLocalDate();
        this.historyDao.saveDelete(userId,localDate.toString(),localTime.toString(),matricule);
    }
}
