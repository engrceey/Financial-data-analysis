package com.pectusfinance.financialrecord.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparseDataResponseDto {
    private String departments;
    private String memberName;
    private BigDecimal amount;

}
