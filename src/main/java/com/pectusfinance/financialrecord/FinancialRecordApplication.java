package com.pectusfinance.financialrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FinancialRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialRecordApplication.class, args);
	}

}
