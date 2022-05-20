package com.pectusfinance.financialrecord.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpansesResponseDto {
    private String id;
    private String departments;
    private String projectName;
    private BigDecimal amount;
    private LocalDate date;
    private String memberName;
}
