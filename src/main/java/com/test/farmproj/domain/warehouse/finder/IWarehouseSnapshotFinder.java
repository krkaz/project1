package com.test.farmproj.domain.warehouse.finder;

import java.util.List;

import com.test.farmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;

public interface IWarehouseSnapshotFinder {

   ProductInWarehouseSnapshot findById(Long productId);

   List<ProductInWarehouseSnapshot> findAll();
}
