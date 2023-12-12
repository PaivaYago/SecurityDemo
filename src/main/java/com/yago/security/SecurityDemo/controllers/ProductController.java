package com.yago.security.SecurityDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yago.security.SecurityDemo.domain.product.Product;
import com.yago.security.SecurityDemo.domain.product.ProductRequestDTO;
import com.yago.security.SecurityDemo.domain.product.ProductResponseDTO;
import com.yago.security.SecurityDemo.repositories.ProductRepository;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@PostMapping
	public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body) {
		Product newProduct = new Product(body);

		this.repository.save(newProduct);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity getAllProducts() {
		List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();
		
		return ResponseEntity.ok(productList);
	}

}
