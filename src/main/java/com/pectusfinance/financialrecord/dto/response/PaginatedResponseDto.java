package com.pectusfinance.financialrecord.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaginatedResponseDto<T> implements Serializable {

    private List<T> content;
    private long totalElements;
}
