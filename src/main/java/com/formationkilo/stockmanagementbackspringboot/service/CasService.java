package com.formationkilo.stockmanagementbackspringboot.service;

import com.formationkilo.stockmanagementbackspringboot.dao.ICas;
import com.formationkilo.stockmanagementbackspringboot.entities.Cas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//@CrossOrigin("*")
@RestController
public class CasService {
    @Autowired
    private ICas casdao;

    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(value = "/corona/cas", method = RequestMethod.GET)
    public List<Cas>getAll(){
        return casdao.findAll();
    }
    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(value = "/corona/casparville", method = RequestMethod.GET)
    public List<Cas>getAllCasByVille(@RequestParam String ville){
        return casdao.getAllCasByVille(ville);
    }

    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(value = "/corona/casparquartier", method = RequestMethod.GET)
    public List<Cas> getAllCasByQuartier(@RequestParam String quartier){

        return casdao.getAllCasByQuartier(quartier);
    }

    @CrossOrigin(origins = "http://localhost:5000")
    @RequestMapping(value = "/corona/cas/save", method = RequestMethod.POST)
    public  List<Cas>save(Cas cas, @RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
         cas.setDate(datecas);
         casdao.save(cas);
         return casdao.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3001")
    @RequestMapping(value = "/corona/cas/delete/{id}", method = RequestMethod.DELETE)
    public  List<Cas>delete(@PathVariable int id){
        if(casdao.getById(id)!=null){
            casdao.delete(casdao.getById(id));
        }
       return casdao.findAll();
    }
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:5000"})
    @RequestMapping(value = "/corona/cas/get", method = RequestMethod.GET)
    public Cas get(@RequestParam int id){
        return casdao.getById(id);
    }


    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3001"})
    @RequestMapping(value = "/corona/cas/update/{id}", method = RequestMethod.PUT)
    public  List<Cas>update(@PathVariable int id, Cas cas, @RequestParam("datecas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datecas){
        cas.setId(id);
        cas.setDate(datecas);
        casdao.save(cas);
        return casdao.findAll();
    }


}
