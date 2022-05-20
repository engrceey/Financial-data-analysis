package com.pectusfinance.financialrecord.repository;

import com.pectusfinance.financialrecord.entity.Expanses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpansesRepository extends JpaRepository<Expanses, Long> {
    @Query(value = "SELECT * FROM expanses e WHERE e.amount >= :field1 or e.member_name = :field2",
    countQuery = "SELECT count(*) FROM expanses",  nativeQuery = true)
    Page<Expanses> filterByOneOrMoreFields(
            @Param("field1") Double field1,
            @Param("field2") String field2,
            Pageable pageable
    );

//    @Query(value = "SELECT SUM(amount) FROM expanses" , nativeQuery = true)
//    Double sumBySelectedField(@Param("field2") String field2);
}
