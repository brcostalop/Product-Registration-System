package com.brcostalop.products.controller;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.service.ProductService;
import com.brcostalop.products.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> listAll() {
        return ApiResponse.successFactory(productService.allList());
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDto) {
        return ApiResponse.successFactory(productService.save(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return ApiResponse.successFactory(productService.update(id, productDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> search(@PathVariable Long id) {
        return ApiResponse.successFactory(productService.searchById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchByFilter(@RequestParam Map<String, String> filters) {
        return ApiResponse.successFactory(productService.searchByFilter(filters));
    }

}
