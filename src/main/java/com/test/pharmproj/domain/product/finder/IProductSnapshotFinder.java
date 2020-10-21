package com.test.pharmproj.domain.product.finder;

import java.util.List;

import com.test.pharmproj.domain.product.dto.ProductSnapshot;

public interface IProductSnapshotFinder {

   ProductSnapshot findById(Long id);

   ProductSnapshot findByName(String name);

   List<ProductSnapshot> findAll();
}
