package com.spring.pneu.services;

import com.spring.pneu.entity.Dimension;

import java.util.List;

public interface DimensionService {
    public List<Dimension> getDimensions();
    public Dimension saveDimension(Dimension dimension);

}
