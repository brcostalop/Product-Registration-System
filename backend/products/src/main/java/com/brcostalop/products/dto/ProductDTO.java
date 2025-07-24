package com.brcostalop.products.dto;

import lombok.Data;

public record ProductDTO (

    Long id,
    String name,
    String category,
    double price,
    String description

){}
