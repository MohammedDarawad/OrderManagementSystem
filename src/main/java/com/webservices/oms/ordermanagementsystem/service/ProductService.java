package com.webservices.oms.ordermanagementsystem.service;

import com.webservices.oms.ordermanagementsystem.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(int productId);

    ProductDTO addProduct(ProductDTO productDTO, int categoryId);

    void removeProduct(int productId);
}
