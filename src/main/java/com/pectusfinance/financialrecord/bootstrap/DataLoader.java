package com.pectusfinance.financialrecord.bootstrap;


import com.pectusfinance.financialrecord.entity.Expanse;
import com.pectusfinance.financialrecord.repository.ExpansesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader {

    public DataLoader() {
    }

    @Autowired
    private ExpansesRepository expansesRepository;


    public void loadData() {
        log.info("Inside Data Loader");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""
                + "[M/dd/yyyy]"
                + "[MM/dd/yyyy]"
                + "[M/d/yyyy]"
                + "[MM/d/yyyy]"
        );

        List<Expanse> expansesList = new ArrayList<>(List.of(new Expanse( "pet", "drilling", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1991", formatter),"ceey"),
            new Expanse( "gas", "gas lifting", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1991", formatter),"bundu"),
         new Expanse( "mech", "car", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1999", formatter),"stephen"),
         new Expanse( "java", "fintech app", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1999", formatter),"zurum"),
        new Expanse( "node", "blog", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1998", formatter),"mark"),
        new Expanse( "csharp", "Bank", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1997", formatter),"louis"),
         new Expanse( "go", "mail", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1996", formatter),"victor"),
         new Expanse( "vue", "instagram", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1996", formatter),"kbiru"),
         new Expanse( "ruby", "blog", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1997", formatter),"negge"),
         new Expanse( "python", "analysis", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1990", formatter),"bella")

        ));

        log.info("List of Data");
        if (expansesRepository.findById(1L).isEmpty())
            {
                log.info("Loading data to the DB");
                expansesRepository.saveAll(expansesList);
            }


        }
}
