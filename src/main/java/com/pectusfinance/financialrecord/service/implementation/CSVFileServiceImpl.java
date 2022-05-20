package com.pectusfinance.financialrecord.service.implementation;

import com.pectusfinance.financialrecord.entity.Expanses;
import com.pectusfinance.financialrecord.repository.ExpansesRepository;
import com.pectusfinance.financialrecord.service.CSVFileService;
import com.pectusfinance.financialrecord.utils.CSVFileLoaderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CSVFileServiceImpl implements CSVFileService {

    private final ExpansesRepository expansesRepository;

    @Override
    @Transactional
    public void saveFileToDB(MultipartFile file) {
        log.info("About to save file to DB ::File:: {}", file.getOriginalFilename());
        try {
            List<Expanses> tutorials = CSVFileLoaderUtil.readCSVtoList(file.getInputStream());

            log.info("Saving csv file :: {} :: to DB",file.getOriginalFilename());
            expansesRepository.saveAll(tutorials);
        } catch (IOException e) {
            log.error("An exception occurred while saving csv to DB ::Message:: {}",e.getMessage());
            throw new RuntimeException("fail to save csv data ::Message:: " + e.getMessage());
        }
    }
}
