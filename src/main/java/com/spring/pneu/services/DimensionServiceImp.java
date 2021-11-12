package com.spring.pneu.services;

import com.spring.pneu.Dao.DimensionDao;
import com.spring.pneu.entity.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class DimensionServiceImp implements DimensionService{

    @Autowired
    private DimensionDao dimensionDao;
    @Override
    @Transactional
    public List<Dimension> getDimensions() {
        return this.dimensionDao.findAll();
    }

    @Override
    @Transactional
    public Dimension saveDimension(Dimension dimension)
    {
        return this.dimensionDao.save(dimension);
    }


}
