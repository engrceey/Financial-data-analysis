package com.pectusfinance.financialrecord.repository;

import com.pectusfinance.financialrecord.entity.Expanse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface ExpansesRepository extends JpaRepository<Expanse, Long> {
    @Query(value = "SELECT * FROM expanses e WHERE e.amount >= :field1 or e.member_name = :field2",
            countQuery = "SELECT count(*) FROM expanses", nativeQuery = true)
    Page<Expanse> filterByOneOrMoreFields(
            @Param("field1") Double field1,
            @Param("field2") String field2,
            Pageable pageable
    );

    @Query(value = "SELECT SUM(amount) FROM expanses e WHERE e.departments = :field", nativeQuery = true)
    Optional<BigDecimal> sumExpansesByDepartment(@Param("field") String field);

    @Query(value = "SELECT amount FROM expanses e WHERE e.member_name = :field1 AND e.date = :field2", nativeQuery = true)
    Optional<BigDecimal> getAmountForMemberByNameAndDate(
            @Param("field1") String field1,
            @Param("field2") LocalDate field2
    );

}
