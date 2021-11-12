package com.spring.pneu.rest;

import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.client;
import com.spring.pneu.services.ClientService;
import com.spring.pneu.services.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")

public class ClientsApi {

    @Autowired
    private ClientService clientService;

    @GetMapping("/findAll")
    public List<client> getDimension()
    {
        return this.clientService.getClients();
    }

}