package com.pectusfinance.financialrecord.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ExpansesResponseDto {
    private String departments;
    private String projectName;
    private BigDecimal amount;
    private Timestamp date;
    private String memberName;
}
