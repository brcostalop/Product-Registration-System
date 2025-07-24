package com.brcostalop.products.service;

import com.brcostalop.products.entity.Product;
import com.brcostalop.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listarProdutos() {
        return productRepository.findAll();
    }

//    @Transactional
    public void criarProduto(Product product) {
        productRepository.save(product);
    }

}
