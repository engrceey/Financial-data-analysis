package com.pectusfinance.financialrecord.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExpansesService {
    void saveFileToDB(MultipartFile file);
}
