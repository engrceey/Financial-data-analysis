package com.pectusfinance.financialrecord.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FetchAmountByNameAndDateRequestDto {
    @JsonAlias("member_name")
    private String memberName;
    @JsonAlias("date")
    private LocalDate date;
}
