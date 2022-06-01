package com.webservices.oms.ordermanagementsystem.service.impl;

import com.webservices.oms.ordermanagementsystem.dto.ProductDTO;
import com.webservices.oms.ordermanagementsystem.entity.Product;
import com.webservices.oms.ordermanagementsystem.exception.ResourceNotFoundException;
import com.webservices.oms.ordermanagementsystem.repository.ProductRepository;
import com.webservices.oms.ordermanagementsystem.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("CategoryEntity", "id", productId));
        return mapToDTO(product);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);

        Product newProduct = productRepository.save(product);

        ProductDTO productResponse = mapToDTO(newProduct);
        return productResponse;
    }

    @Override
    public void removeProduct(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("CategoryEntity", "id", productId));
        productRepository.delete(product);
    }

    private ProductDTO mapToDTO(Product Product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(Product.getId());
        productDTO.setPrice(Product.getPrice());
        productDTO.setReference(Product.getReference());
        productDTO.setName(Product.getName());
        productDTO.setSlug(Product.getSlug());
        productDTO.setStockable(Product.isStockable());
        productDTO.setVat(Product.getVat());
        return productDTO;
    }

    private Product mapToEntity(ProductDTO productDTO) {
        Product Product = new Product();
        Product.setId(productDTO.getId());
        Product.setPrice(productDTO.getPrice());
        Product.setReference(productDTO.getReference());
        Product.setName(productDTO.getName());
        Product.setStockable(productDTO.isStockable());
        Product.setVat(productDTO.getVat());
        Product.setSlug(productDTO.getSlug());
        return Product;
    }
}
