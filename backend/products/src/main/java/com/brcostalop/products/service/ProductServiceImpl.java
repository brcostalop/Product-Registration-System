package com.brcostalop.products.service;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.entity.Product;
import com.brcostalop.products.exception.InvalidFieldException;
import com.brcostalop.products.mapper.ProductMapper;
import com.brcostalop.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    @Override
    public ProductDTO save(ProductDTO productDto) throws InvalidFieldException {
        if (productDto.price() < 0) {
            throw new InvalidFieldException("Campo Inválido",
                    "O preço do produto não pode ser negativo", "O preço do produto não pode ser negativo");
        }
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> allList() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ProductDTO update(Long id, ProductDTO productDto) throws InvalidFieldException {
        if (productDto.price() < 0) {
            throw new InvalidFieldException("Campo Inválido",
                    "O preço do produto não pode ser negativo", "O preço do produto não pode ser negativo");
        }
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDto.name());
        product.setCategory(productDto.category());
        product.setPrice(productDto.price());
        product.setDescription(productDto.description());
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO searchById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<ProductDTO> searchByFilter(Map<String, String> filter) {
        return productRepository.findAll().stream()
                .filter(product -> {
                    boolean match = true;
                    if (filter.containsKey("name")) {
                        match &= product.getName().toLowerCase().contains(filter.get("name").toLowerCase());
                    }
                    if (filter.containsKey("category")) {
                        match &= product.getCategory().equalsIgnoreCase(filter.get("category"));
                    }
                    return match;
                })
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
