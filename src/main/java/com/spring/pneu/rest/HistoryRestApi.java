package com.spring.pneu.rest;

import com.spring.pneu.entity.History;
import com.spring.pneu.entity.TireDetails;
import com.spring.pneu.entity.User;
import com.spring.pneu.services.HistoryService;
import com.spring.pneu.services.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")

public class HistoryRestApi {
    @Autowired
    private HistoryService historyService;
    @GetMapping("/history/{id}")
    public List<History> getUserHistory(@PathVariable int id) {
        return this.historyService.getUserHistory(id);
    }
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return this.historyService.getAllUsers();
    }
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) throws Exception {
        try {
            return this.historyService.save(user);
        } catch (Exception e) {
            throw new Exception("Username already Exists!");
        }
    }


}