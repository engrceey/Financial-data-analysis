package com.pectusfinance.financialrecord.controllers;

import com.pectusfinance.financialrecord.dto.response.ApiResponse;
import com.pectusfinance.financialrecord.dto.response.ExpansesResponseDto;
import com.pectusfinance.financialrecord.dto.response.PaginatedResponseDto;
import com.pectusfinance.financialrecord.service.ExpansesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/expanse")
public class ExpansesController {

    private final ExpansesService expansesService;

    @GetMapping(path="expanses")
    public ResponseEntity<ApiResponse<PaginatedResponseDto<ExpansesResponseDto>>> getExpanses(
            @RequestParam(defaultValue = "0") int start,
            @RequestParam(defaultValue = "10") int limit
    ) {
        PaginatedResponseDto<ExpansesResponseDto> response = expansesService.fetchExpanses(start, limit);
        return ResponseEntity.ok().body(ApiResponse.<PaginatedResponseDto<ExpansesResponseDto>>builder()
                .data(response)
                .isSuccessful(true)
                .statusMessage("success")
                .build());
    }
}
