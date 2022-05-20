package com.pectusfinance.financialrecord.service.implementation;

import com.pectusfinance.financialrecord.dto.response.ExpansesResponseDto;
import com.pectusfinance.financialrecord.dto.response.PaginatedResponseDto;
import com.pectusfinance.financialrecord.entity.Expanses;
import com.pectusfinance.financialrecord.exceptions.CustomException;
import com.pectusfinance.financialrecord.exceptions.ResourceNotFoundException;
import com.pectusfinance.financialrecord.repository.ExpansesRepository;
import com.pectusfinance.financialrecord.service.ExpansesService;
import com.pectusfinance.financialrecord.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpansesServiceImpl implements ExpansesService {

    private final ExpansesRepository expansesRepository;

    @Override
    @Cacheable("expanses")
    public PaginatedResponseDto<ExpansesResponseDto> fetchExpanses(int start, int limit) {
        Page<Expanses> expanses = expansesRepository.findAll(PageRequest.of(start, limit));
        if (expanses.isEmpty()) {
            throw new CustomException("No expanse info available", HttpStatus.NO_CONTENT);
        }

        return PaginatedResponseDto.<ExpansesResponseDto>builder()
                .content(ModelMapperUtils.mapAll(expanses.getContent(), ExpansesResponseDto.class))
                .totalElements(expanses.getTotalElements())
                .build();
    }


    @Override
    @Cacheable(value = "sortedExpanses")
    public List<ExpansesResponseDto> fetchExpansesSorted(int start, int limit, String sortBy) {
        Pageable paging = PageRequest.of(start, limit, Sort.by(sortBy));
        Page<Expanses> pagedResult = expansesRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return ModelMapperUtils.mapAll(pagedResult.getContent(), ExpansesResponseDto.class);
        } else {
            throw new ResourceNotFoundException("No expanse info available", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Cacheable(value = "multiSortedExpanses")
    public List<ExpansesResponseDto> fetchExpansesSortedByOneOrMoreFields(int start, int limit, String field1, String field2) {
        Pageable paging = PageRequest.of(start, limit, Sort.by(Sort.Direction.DESC, field1, field2));
        Page<Expanses> pagedResult = expansesRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return ModelMapperUtils.mapAll(pagedResult.getContent(), ExpansesResponseDto.class);
        } else {
            throw new ResourceNotFoundException("No expanse info available", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Cacheable(value = "filteredExpanses")
    public List<ExpansesResponseDto> filterByAmountOrMemberName(int start, int limit, Double field1, String field2) {

        Pageable paging = PageRequest.of(start, limit);
        Page<Expanses> pagedResult = expansesRepository.filterByOneOrMoreFields(field1, field2, paging);
        if (pagedResult.hasContent()) {
            return ModelMapperUtils.mapAll(pagedResult.getContent(), ExpansesResponseDto.class);
        } else {
            throw new ResourceNotFoundException("No expanse info available", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BigDecimal fetchSumOfExpansesByDepartment(String field) {
        log.info("fetching expenses for :: {} :: department", expansesRepository.sumExpansesByDepartment(field).toString());

        return expansesRepository.sumExpansesByDepartment(field)
                .orElseThrow(
                        () -> {
                            throw new ResourceNotFoundException("No value found for "+field+" department");
                        }
                );
    }


}
