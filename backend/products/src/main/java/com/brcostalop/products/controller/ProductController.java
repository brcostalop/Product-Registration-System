package com.brcostalop.products.controller;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.exception.HandlerException;
import com.brcostalop.products.service.ProductService;
import com.brcostalop.products.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Object> save(@RequestBody ProductDTO productDto) {
        try {
            return ApiResponse.successFactory(productService.save(productDto));
        } catch (HandlerException e) {
            return ApiResponse.failureFactory(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        try {
            return ApiResponse.successFactory(productService.update(id, productDTO));
        } catch (HandlerException e) {
            return ApiResponse.failureFactory(e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> searchById(@PathVariable Long id) {
        return ApiResponse.successFactory(productService.searchById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchByFilter(@RequestParam Map<String, String> filters) {
        return ApiResponse.successFactory(productService.searchByFilter(filters));
    }

    @GetMapping("/page")
    public ResponseEntity<Object> listPage(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "name") String sortBy) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
            return ApiResponse.successFactory(productService.listPaginated(pageable));
        } catch (HandlerException e) {
            return ApiResponse.failureFactory(e);
        }
    }

}
