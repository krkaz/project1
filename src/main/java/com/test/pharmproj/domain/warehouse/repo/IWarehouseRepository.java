package com.test.pharmproj.domain.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.pharmproj.domain.warehouse.entity.Warehouse;

public interface IWarehouseRepository
      extends JpaRepository<Warehouse, Long> {

   Warehouse findByProductId(Long productId);
}
