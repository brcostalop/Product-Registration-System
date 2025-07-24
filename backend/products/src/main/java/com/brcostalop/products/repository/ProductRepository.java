package com.brcostalop.products.repository;

import com.brcostalop.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<Product> findList();

}
