package com.test.farmproj.domain.warehouse.finder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.farmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;
import com.test.farmproj.domain.warehouse.dto.WarehouseSnapshot;
import com.test.farmproj.domain.warehouse.entity.Warehouse;
import com.test.farmproj.domain.warehouse.repo.IWarehouseRepository;

@Component
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class WarehouseSnapshotFinder
      implements IWarehouseSnapshotFinder {

   private final IWarehouseRepository warehouseRepository;

   @Autowired
   public WarehouseSnapshotFinder(IWarehouseRepository warehouseRepository) {
      this.warehouseRepository = warehouseRepository;
   }

//   @Override
//   public ProductSnapshot findById(Long id) {
//      Optional<Product> product = productRepository.findById(id);
//      return product.map(Product::toSnapshot)
//                 .orElse(null);
//   }
//
//   @Override
//   public ProductSnapshot findByName(String name) {
//      Optional<Product> product = productRepository.findByName(name);
//      return product.map(Product::toSnapshot)
//                    .orElse(null);
//   }

   @Override
   public ProductInWarehouseSnapshot findById(Long productId) {
      Optional<Warehouse> warehouse = warehouseRepository.findById(productId);
      return warehouse.map(Warehouse::toSnapshot)
                      .orElseThrow(EntityNotFoundException::new);
   }

   @Override
   public List<ProductInWarehouseSnapshot> findAll() {
      return warehouseRepository.findAll()
                                .stream()
                                .map(Warehouse::toSnapshot)
                                .collect(Collectors.toList());
   }
}
