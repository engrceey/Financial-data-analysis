package com.pectusfinance.financialrecord.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ExpansesRequestDto {

    private String departments;

    private String projectName;

    private BigDecimal amount;

    private Timestamp date;

    private String memberName;

}
