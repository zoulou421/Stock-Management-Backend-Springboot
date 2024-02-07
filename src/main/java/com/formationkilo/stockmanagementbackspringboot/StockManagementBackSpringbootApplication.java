package com.formationkilo.stockmanagementbackspringboot;

import com.formationkilo.stockmanagementbackspringboot.dao.ICas;
import com.formationkilo.stockmanagementbackspringboot.entities.Cas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class StockManagementBackSpringbootApplication implements CommandLineRunner {
    @Autowired
    private ICas casdao;
    public static void main(String[] args) {
        SpringApplication.run(StockManagementBackSpringbootApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        Cas cas = new Cas();
        cas.setVille("Dakar");
        cas.setQuartier("Liberte 6 extension");

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse("2020-04-28");
        cas.setDate(date);

        cas.setVille("Dakar Sacré Coeur");
        cas.setQuartier("Test quartier");

        Date date1 = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse("2020-04-28");
        cas.setDate(date);

        //casdao.save(cas);
        casdao.save(cas);
        casdao.findAll().forEach(c -> System.out.println(c.getVille()));
    }
}
