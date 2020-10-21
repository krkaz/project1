package com.test.pharmproj.domain.product.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pharmproj.domain.product.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

   Optional<Product> findByName(String name);
}
