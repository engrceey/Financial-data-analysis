package com.pectusfinance.financialrecord.dto.response;

import lombok.Data;

@Data
public class CSVResponseDto {
    private String message;
    private String fileDownloadUri;

    public CSVResponseDto(String message, String fileDownloadUri) {
        this.message = message;
        this.fileDownloadUri = fileDownloadUri;
    }
}
