package com.pectusfinance.financialrecord.service.implementation;

import com.pectusfinance.financialrecord.dto.response.ExpansesResponseDto;
import com.pectusfinance.financialrecord.dto.response.PaginatedResponseDto;
import com.pectusfinance.financialrecord.entity.Expanses;
import com.pectusfinance.financialrecord.exceptions.CustomException;
import com.pectusfinance.financialrecord.repository.ExpansesRepository;
import com.pectusfinance.financialrecord.service.ExpansesService;
import com.pectusfinance.financialrecord.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpansesServiceImpl implements ExpansesService {

    private final ExpansesRepository expansesRepository;

    @Override
    public PaginatedResponseDto<ExpansesResponseDto> fetchExpanses(int start, int limit) {
        Page<Expanses> expanses = expansesRepository.findAll(PageRequest.of(start, limit));
        if (expanses.isEmpty()) {
            throw new CustomException("No expanse info available", HttpStatus.NO_CONTENT);
        }

        log.info("PAGE >>>> {}", expanses);
        return PaginatedResponseDto.<ExpansesResponseDto>builder()
                .content(ModelMapperUtils.mapAll(expanses.getContent(), ExpansesResponseDto.class))
                .totalElements(expanses.getTotalElements())
                .build();
    }

}
