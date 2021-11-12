package com.spring.pneu.services;

import com.spring.pneu.Dao.ClientsDao;
import com.spring.pneu.Dao.DimensionDao;
import com.spring.pneu.Dao.TiresDao;
import com.spring.pneu.converter.Converter;
import com.spring.pneu.entity.Dimension;
import com.spring.pneu.entity.Tire;
import com.spring.pneu.entity.TireDetails;
import com.spring.pneu.entity.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class TireServiceImp implements TireService {

    @Autowired
    private TiresDao tiresDao;
    @Autowired
    private Converter converter;
    @Autowired
    private DimensionDao dimensionDao;
    @Autowired
    private ClientsDao clientDao;
    /*public TireServiceImp()
    {

    }
    public TireServiceImp(TiresDao tiresDao)
    {
        this.tiresDao=tiresDao;
    }*/
    @Transactional
    public List<TireDetails> getTires() {
        List<Tire> tires=tiresDao.findAll();
        return converter.entityToDto(tires) ;  }

    @Override
    @Transactional
    public Tire getTire(int id) {

            Tire tire= this.tiresDao.findById(id);
            return tire;
            //SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
    }

    @Override
    @Transactional
    public Tire updateTire(Tire tire,int id) {

        Tire newTire= tiresDao.findById(id);
        newTire.setDestinaire(tire.getDestinaire());
        newTire.setOrigine(tire.getOrigine());
        newTire.setDestinaire(tire.getDestinaire());
        newTire.setDateLivraison(tire.getDateLivraison());
        newTire.setEtat(tire.getEtat());
        newTire.setGomme(tire.getGomme());
        newTire.setMarque(tire.getMarque());
        newTire.setMatricule(tire.getMatricule());
        newTire.setPrix(tire.getPrix());
        newTire.setOccasion(tire.isOccasion());
        newTire.setRechape(tire.isRechape());
        newTire.setRepare(tire.isRepare());
        newTire.setUa(tire.isUa());
        newTire.setId(id);
        newTire.setDimension(tire.getDimension());
        newTire.setMarque(tire.getMarque());
        if(tire.getReparationExt()!=null)
        {
            newTire.setReparationExt(tire.getReparationExt());
        }
        if(tire.getReparationInt()!=null)
        {
            newTire.setReparationInt(tire.getReparationInt());
        }if(tire.getControle()!=null)
        {
            newTire.setControle(tire.getControle());
        }if(tire.getControle()!=null)
        {
            newTire.setControle(tire.getControle());
        }if(tire.getGomme()!=null)
        {
            newTire.setGomme(tire.getGomme());
        }if(tire.getCuisson()!=null)
        {
            newTire.setCuisson(tire.getCuisson());
        }if(tire.getDessin()!=null)
        {
            newTire.setDessin(tire.getDessin());
        }
        if(tire.getPeinture()!=null)
        {
            newTire.setPeinture(tire.getPeinture());
        }
        tiresDao.save(newTire);
        return newTire;
        //SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
    }


    @Override
    @Transactional
    public Tire saveTire(Tire tire) {

        client orig=clientDao.findById(tire.getOrigine().getId()).get();
        tire.setOrigine(orig);
        client dest=clientDao.findById(tire.getDestinaire().getId()).get();
        tire.setDestinaire(dest);

        //tire.getControle().setId(null);
      //  tire.
       /* if(!tire.getControle().empty())
        {
            tire.setControle();
        }*/

       /* if(tire.getDimension()!=null)
        {
            System.out.println("zakzouka "+tire.getControle().getDate());
        }*/
        return this.tiresDao.save(tire);
    }


    @Override
    @Transactional
    public void deleteTire(int id) {
        this.tiresDao.deleteById(id);

    }

}
