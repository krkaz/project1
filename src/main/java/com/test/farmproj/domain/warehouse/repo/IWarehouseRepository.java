package com.test.farmproj.domain.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.farmproj.domain.warehouse.entity.Warehouse;

public interface IWarehouseRepository
      extends JpaRepository<Warehouse, Long> {
}
