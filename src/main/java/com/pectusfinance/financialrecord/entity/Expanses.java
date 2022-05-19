package com.pectusfinance.financialrecord.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "expanses")
public class Expanses extends BaseEntity {

    @Column(name = "departments")
    private String departments;

    @Column(name = "project_name")
    private String projectName;

    private BigDecimal amount;

    private Timestamp date;

    @Column(name = "member_name")
    private String memberName;
}
