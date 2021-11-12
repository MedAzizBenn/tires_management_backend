package com.spring.pneu.services;

import com.spring.pneu.entity.Marque;

import java.util.List;

public interface BrandService {
    public List<Marque> getBrands();
    public Marque saveBrand(Marque marque);

}
