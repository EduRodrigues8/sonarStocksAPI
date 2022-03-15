package com.example.Stock.Services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import com.example.Stock.models.stock;
import com.example.Stock.repository.stockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.Stock.models.stock;
// import com.example.Stock.repository.stockRepository;

@Service
public class stockService {
    @Autowired
    stockRepository repository;

    // GET

    public List<stock> findAll() {
        return repository.findAll();
    }

    // GET by ID
    public stock findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // PUT ID
    public stock updateById(Long id, stock stocks) {
        stock updateStocks = findById(id);
        if (updateStocks == null) {
            return null;
        } else {
            updateStocks.setAsk_min(stocks.getAsk_min());
            updateStocks.setAsk_max(stocks.getAsk_max());
            updateStocks.setBid_min(stocks.getBid_min());
            updateStocks.setBid_max(stocks.getBid_max());
            updateStocks.setUpdated_on(Timestamp.from(Instant.now()));
            return repository.save(stocks);
        }
    }

    // POST
    public stock save(stock stocks) {
        return repository.save(stocks);
    }

}