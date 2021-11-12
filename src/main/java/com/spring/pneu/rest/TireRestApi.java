package com.spring.pneu.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.pneu.Dao.AuthenticationDao;
import com.spring.pneu.entity.*;
import com.spring.pneu.services.HistoryService;
import com.spring.pneu.services.TireService;
import com.spring.pneu.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/tires")

public class TireRestApi {
    @Autowired
    private TireService tireService;
    @Autowired
    private HistoryService historyService;

    @Autowired
    private AuthenticationDao authentication;

    @GetMapping("/findAll")
    public List<TireDetails> getTires()
    {
        return this.tireService.getTires();
    }
    @GetMapping("/find/{id}")
    public Tire getTire(@PathVariable int id)
    {

        return this.tireService.getTire(id);
    }

    @PostMapping("/post/{username}")
    public Tire save(@RequestBody Tire tire,@PathVariable String username)
    {
        Optional<User> user=this.authentication.findByUsername(username);
        this.historyService.addInsertHistory(user.get().getId(),tire.getMatricule());
        return this.tireService.saveTire(tire);
    }
    @PutMapping("/update/{username}/{id}")
    public Tire updateTire(@RequestBody Tire tire,@PathVariable String username,@PathVariable int id)
    {
        Optional<User> user=this.authentication.findByUsername(username);
        this.historyService.addUpdateHistory(user.get().getId(),tire.getMatricule());
        return this.tireService.updateTire(tire,id);
    }
    @DeleteMapping("/delete/{username}/{id}")
    public void deletePurchase(@PathVariable String username,@PathVariable int id)
    {
        Optional<User> user=this.authentication.findByUsername(username);
        Tire tire=this.tireService.getTire(id);
        this.historyService.addDeleteHistory(user.get().getId(),tire.getMatricule());
        this.tireService.deleteTire(id);
    }


}
