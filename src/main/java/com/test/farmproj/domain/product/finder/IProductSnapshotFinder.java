package com.test.farmproj.domain.product.finder;

import java.util.List;

import com.test.farmproj.domain.product.dto.ProductSnapshot;

public interface IProductSnapshotFinder {

   ProductSnapshot findById(Long id);

   ProductSnapshot findByName(String name);

   List<ProductSnapshot> findAll();
}
