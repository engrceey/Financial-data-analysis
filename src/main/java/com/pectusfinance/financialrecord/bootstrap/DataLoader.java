package com.pectusfinance.financialrecord.bootstrap;


import com.pectusfinance.financialrecord.entity.Expanse;
import com.pectusfinance.financialrecord.repository.ExpansesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader {

    private final ExpansesRepository expansesRepository;

    public boolean loadData() {
        Expanse expanseA = new Expanse( "pet", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseB = new Expanse( "gas", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseC = new Expanse( "mech", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseD = new Expanse( "java", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseE = new Expanse( "node", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseF = new Expanse( "csharp", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseG = new Expanse( "go", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseH = new Expanse( "vue", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseI = new Expanse( "ruby", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");
        Expanse expanseJ = new Expanse( "python", "ExtraWin", BigDecimal.valueOf(10000.90), LocalDate.parse("01/02/1199"),"Abidemi");

        return true;
    }
}
