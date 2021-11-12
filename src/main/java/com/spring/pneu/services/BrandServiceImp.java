package com.spring.pneu.services;

import com.spring.pneu.Dao.BrandDao;
import com.spring.pneu.Dao.ClientsDao;
import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.Marque;
import com.spring.pneu.entity.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandServiceImp implements BrandService{

    @Autowired
    private BrandDao brandDao;
    @Override
    public List<Marque> getBrands() {
        return this.brandDao.findAll();
    }
    @Override
    @Transactional
    public Marque saveBrand(Marque marque) {
        return this.brandDao.save(marque);
    }

}
