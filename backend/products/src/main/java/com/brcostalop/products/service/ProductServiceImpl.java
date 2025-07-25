package com.brcostalop.products.service;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.entity.Product;
import com.brcostalop.products.mapper.ProductMapper;
import com.brcostalop.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductDTO productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> allList() {
        List<Product> productList = productRepository.findAll();
        return productMapper.toDtos(productList);
    }

    @Override
    public ProductDTO update(String id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ProductDTO searchById(String id) {
        return null;
    }

    @Override
    public List<ProductDTO> searchByFilter(Map<String, String> filter) {
        return List.of();
    }
}
