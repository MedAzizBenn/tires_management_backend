package com.spring.pneu.rest;

import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.Tire;
import com.spring.pneu.services.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dimension")

public class DimensionApi {

    @Autowired
    private DimensionService dimensionService;

    @GetMapping("/findAll")
    public List<Dimension> getDimension()
    {
        return this.dimensionService.getDimensions();
    }

    @PostMapping("/post")
    public Dimension saveDimension(@RequestBody Dimension dimension)
    {
        return this.dimensionService.saveDimension(dimension);
    }

}
