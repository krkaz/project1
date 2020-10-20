package com.test.farmproj.domain.product.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.farmproj.domain.product.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

   Optional<Product> findByName(String name);
}
