package com.example.Stock.repository;

import java.util.List;

import com.example.Stock.models.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface stockRepository extends JpaRepository<stock, Long> {

    // @Query(value = "select * from stocks where stock_symbol = :stock_symbol",
    // nativeQuery = true)
    // stock findBySymbol(@Param("stock_symbol") String stock_symbol);

    @Query(value = "select * from stocks fetch first 5 rows only", nativeQuery = true)
    List<stock> ListaStock();
}