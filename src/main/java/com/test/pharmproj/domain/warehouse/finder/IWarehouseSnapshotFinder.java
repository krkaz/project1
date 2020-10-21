package com.test.pharmproj.domain.warehouse.finder;

import java.util.List;

import com.test.pharmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;

public interface IWarehouseSnapshotFinder {

   ProductInWarehouseSnapshot findById(Long productId);

   List<ProductInWarehouseSnapshot> findAll();
}
