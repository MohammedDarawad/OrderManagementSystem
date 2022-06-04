package com.webservices.oms.ordermanagementsystem.controller;

import com.webservices.oms.ordermanagementsystem.dto.CustomerDTO;
import com.webservices.oms.ordermanagementsystem.dto.StockDTO;
import com.webservices.oms.ordermanagementsystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockResource {
    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        return ResponseEntity.ok().body(stockService.getAllStocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getStockById(@PathVariable(name = "id") int stockId) {
        return ResponseEntity.ok(stockService.getStockById(stockId));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<StockDTO> createStock(@Valid @RequestBody StockDTO stockDTO, @Valid @PathVariable(name = "productId") int productId) {
        return new ResponseEntity<>(stockService.addStock(stockDTO, productId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable(name = "id") int stockId) {
        stockService.removeStock(stockId);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StockDTO> updateStock(@Valid @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockService.updateStock(stockDTO));
    }
}
