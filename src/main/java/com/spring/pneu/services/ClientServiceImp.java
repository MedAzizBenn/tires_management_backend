package com.spring.pneu.services;

import com.spring.pneu.Dao.ClientsDao;
import com.spring.pneu.entity.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    private ClientsDao clientsDao;
    @Override
    public List<client> getClients() {
        return this.clientsDao.findAll();
    }
}
