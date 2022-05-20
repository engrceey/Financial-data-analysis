package com.pectusfinance.financialrecord.service;

import com.pectusfinance.financialrecord.dto.response.ExpansesResponseDto;
import com.pectusfinance.financialrecord.dto.response.PaginatedResponseDto;

public interface ExpansesService {
    PaginatedResponseDto<ExpansesResponseDto> fetchExpanses(int start, int limit);
}
