package com.pectusfinance.financialrecord.service;

import org.springframework.web.multipart.MultipartFile;

public interface CSVFileService {
    void saveFileToDB(MultipartFile file);
}
