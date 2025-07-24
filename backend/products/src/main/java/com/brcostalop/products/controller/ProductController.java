package com.brcostalop.products.controller;

import com.brcostalop.products.entity.Product;
import com.brcostalop.products.service.ProductService;
import com.brcostalop.products.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

//    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> listAll() {
        return ApiResponse.successFactory(productService.listarProdutos());
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Product product) {
        productService.criarProduto(product);
        return ApiResponse.successFactory();
    }

}
