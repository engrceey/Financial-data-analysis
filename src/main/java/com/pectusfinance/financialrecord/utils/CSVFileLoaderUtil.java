package com.pectusfinance.financialrecord.utils;

import com.pectusfinance.financialrecord.entity.Expanses;
import com.pectusfinance.financialrecord.exceptions.CustomException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVFileLoaderUtil {

    static String[] HEADERS = {"departments", "project_name", "amount", "date", "member_name"};
    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType())
                || Objects.equals(file.getContentType(), "application/vnd.ms-excel");
    }

    public static List<Expanses> readCSVtoList(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Expanses> expansesList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Expanses expanses = Expanses.builder()
                        .amount(BigDecimal.valueOf(Double.parseDouble(csvRecord.get("amount").replace("€", ""))))
                        .memberName(csvRecord.get("member_name"))
                        .departments(csvRecord.get("departments"))
                        .projectName(csvRecord.get("project_name"))
                        .date(Timestamp.valueOf(csvRecord.get("date")))
                        .build();

                expansesList.add(expanses);
            }
            return expansesList;
        } catch (IOException e) {
            throw new CustomException("fail to parse CSV file: " + e.getMessage());
        }
    }


}
