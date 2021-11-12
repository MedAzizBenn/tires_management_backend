package com.spring.pneu.rest;

import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.Marque;
import com.spring.pneu.entity.client;
import com.spring.pneu.services.BrandService;
import com.spring.pneu.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/brands")

public class BrandApi {


    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public List<Marque> getDimension()
    {
        return this.brandService.getBrands();
    }
    @PostMapping("/post")
    public Marque saveBrand(@RequestBody Marque marque)
    {
        return this.brandService.saveBrand(marque);
    }
}