package com.brcostalop.products.service;

import com.brcostalop.products.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductDTO save(ProductDTO productDto);

    ProductDTO update(String id, ProductDTO productDTO);

    void delete(String id);

    ProductDTO searchById(String id);

    List<ProductDTO> allList();

    List<ProductDTO> searchByFilter(Map<String, String> filter);

}
