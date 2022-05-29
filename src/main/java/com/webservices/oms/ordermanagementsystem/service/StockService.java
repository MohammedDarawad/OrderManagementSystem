package com.webservices.oms.ordermanagementsystem.service;

import com.webservices.oms.ordermanagementsystem.dto.ProductDTO;
import com.webservices.oms.ordermanagementsystem.dto.StockDTO;

import java.util.List;

public interface StockService {
    List<StockDTO> getAllStocks();

    StockDTO getStockById(int stockId);

    StockDTO addStock(StockDTO stockDTO,int productId);

    void removeStock(int stockId);
}
