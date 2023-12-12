package com.yago.security.SecurityDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yago.security.SecurityDemo.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
