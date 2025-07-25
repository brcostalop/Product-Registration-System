package com.brcostalop.products.controller;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.service.ProductService;
import com.brcostalop.products.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> listAll() {
        return ApiResponse.successFactory(productService.allList());
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDto) {
        productService.save(productDto);
        return ApiResponse.successFactory();
    }

}
