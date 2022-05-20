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

import java.util.List;


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

    @GetMapping(path="sorted-expanses")
    public ResponseEntity<ApiResponse<List<ExpansesResponseDto>>> getExpansesSorted(
            @RequestParam(defaultValue = "0") Integer start,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "departments") String sortBy)
    {
        List<ExpansesResponseDto> list = expansesService.fetchExpansesSorted(start, limit, sortBy);

        return ResponseEntity.ok().body(ApiResponse.<List<ExpansesResponseDto>>builder()
                .data(list)
                .isSuccessful(true)
                .statusMessage("success")
                .build());
    }

    @GetMapping(path="multi-sort-expanses")
    public ResponseEntity<ApiResponse<List<ExpansesResponseDto>>> getExpansesSortedByOneOrMoreFields(
            @RequestParam(defaultValue = "0") Integer start,
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "departments") String field1,
            @RequestParam(defaultValue = "projectName") String field2
        )
    {
        List<ExpansesResponseDto> list = expansesService.fetchExpansesSortedByOneOrMoreFields(
                start, limit, field1, field2
        );

        return ResponseEntity.ok().body(ApiResponse.<List<ExpansesResponseDto>>builder()
                .data(list)
                .isSuccessful(true)
                .statusMessage("success")
                .build());
    }
}
