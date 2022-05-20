package com.pectusfinance.financialrecord.controllers;


import com.pectusfinance.financialrecord.dto.response.ApiResponse;
import com.pectusfinance.financialrecord.dto.response.CSVResponseDto;
import com.pectusfinance.financialrecord.service.CSVFileService;
import com.pectusfinance.financialrecord.utils.CSVFileLoaderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "csv")
public class CSVFileController {

    private final CSVFileService csvFileService;

    @PostMapping("/upload" )
    public ResponseEntity<ApiResponse<CSVResponseDto>> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVFileLoaderUtil.hasCSVFormat(file)) {
            try {
                csvFileService.saveFileToDB(file);

                message = "file uploaded successfully: " + file.getOriginalFilename();

                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/csv/download/")
                        .path(Objects.requireNonNull(file.getOriginalFilename()))
                        .toUriString();

                return ResponseEntity.ok(ApiResponse.<CSVResponseDto>builder()
                        .isSuccessful(true)
                        .statusMessage("success")
                        .data(new CSVResponseDto(message,fileDownloadUri))
                        .build()
                );


            } catch (Exception e) {
                log.error("Exception occurred while saving data to DB :: Message:: {}",e.getLocalizedMessage());
                log.error("Exception occurred while saving data to DB :: Message:: {}",e.toString());
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ApiResponse.<CSVResponseDto>builder()
                        .isSuccessful(false)
                        .statusMessage("error")
                        .data(new CSVResponseDto(message,""))
                        .build()
                );
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.<CSVResponseDto>builder()
                .isSuccessful(false)
                .statusMessage("failed")
                .data(new CSVResponseDto(message,""))
                .build()
        );
    }
}
