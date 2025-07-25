package com.brcostalop.products.mapper;

import com.brcostalop.products.dto.ProductDTO;
import com.brcostalop.products.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO dto);
    List<ProductDTO> toDtos(List<Product> productList);
    List<Product> toEntitys(List<ProductDTO> productDTOList);

}
