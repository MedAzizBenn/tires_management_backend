package com.spring.pneu.converter;

import com.spring.pneu.entity.Tire;
import com.spring.pneu.entity.TireDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class Converter {
    public List<TireDetails> entityToDto(List<Tire> purchases)
    {
        return purchases.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public TireDetails entityToDto(Tire p)
    {
        TireDetails purchase =new TireDetails();
        purchase.setDateLivraison(p.getDateLivraison());
        purchase.setId(p.getId());
        purchase.setMarque(p.getMarque().getMarque());
        purchase.setMatricule(p.getMatricule());
        purchase.setPrix(p.getPrix());
        //p.setPurchaseId(purchase.getId());
        return purchase;
    }
}
