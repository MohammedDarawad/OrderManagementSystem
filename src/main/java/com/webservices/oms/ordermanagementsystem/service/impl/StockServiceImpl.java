package com.webservices.oms.ordermanagementsystem.service.impl;

import com.webservices.oms.ordermanagementsystem.dto.StockDTO;
import com.webservices.oms.ordermanagementsystem.entity.Product;
import com.webservices.oms.ordermanagementsystem.entity.Stock;
import com.webservices.oms.ordermanagementsystem.exception.ResourceNotFoundException;
import com.webservices.oms.ordermanagementsystem.repository.ProductRepository;
import com.webservices.oms.ordermanagementsystem.repository.StockRepository;
import com.webservices.oms.ordermanagementsystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().map(stock -> mapToDTO(stock)).collect(Collectors.toList());
    }

    @Override
    public StockDTO updateStock(StockDTO stockDTO) {
        int stockId = stockDTO.getId();
        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));

        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdatedAt(LocalDateTime.now());

        Stock updateStock = stockRepository.save(stock);
        return mapToDTO(updateStock);
    }

    @Override
    public StockDTO getStockById(int stockId) {
        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));
        return mapToDTO(stock);
    }

    @Override
    public StockDTO addStock(StockDTO stockDTO, int productId) {
        Stock stock = mapToEntity(stockDTO);

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", productId));
        stock.setProduct(product);

        Stock newStock = stockRepository.save(stock);

        StockDTO stockResponse = mapToDTO(newStock);
        return stockResponse;
    }

    @Override
    public void removeStock(int stockId) {
        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));
        stockRepository.delete(stock);
    }

    private StockDTO mapToDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getId());
        stockDTO.setQuantity(stock.getQuantity());
        stockDTO.setUpdatedAt(stock.getUpdatedAt());
        return stockDTO;
    }

    private Stock mapToEntity(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setId(stockDTO.getId());
        stock.setQuantity(stockDTO.getQuantity());
        stock.setUpdatedAt(stockDTO.getUpdatedAt());
        return stock;
    }
}
