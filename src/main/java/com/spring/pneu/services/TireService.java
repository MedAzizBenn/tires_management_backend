package com.spring.pneu.services;

import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.Tire;
import com.spring.pneu.entity.TireDetails;

import java.util.List;
import java.util.Optional;

public interface TireService {
    public List<TireDetails> getTires();
    public Tire getTire(int id);

    public Tire saveTire(Tire tire);
    public Tire updateTire(Tire tire,int id);
    public void deleteTire(int id);

}