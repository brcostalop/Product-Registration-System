package com.brcostalop.products.service;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.exception.InvalidFieldException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductDTO save(ProductDTO productDto) throws InvalidFieldException;

    ProductDTO update(Long id, ProductDTO productDTO) throws InvalidFieldException;

    void delete(Long id);

    ProductDTO searchById(Long id);

    List<ProductDTO> allList();

    List<ProductDTO> searchByFilter(Map<String, String> filter);

    Page<ProductDTO> listPaginated(Pageable pegeable) throws InvalidFieldException;

}
