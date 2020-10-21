package com.test.pharmproj.domain.warehouse.finder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.pharmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;
import com.test.pharmproj.domain.warehouse.entity.Warehouse;
import com.test.pharmproj.domain.warehouse.repo.IWarehouseRepository;

@Component
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class WarehouseSnapshotFinder
      implements IWarehouseSnapshotFinder {

   private final IWarehouseRepository warehouseRepository;

   @Autowired
   public WarehouseSnapshotFinder(IWarehouseRepository warehouseRepository) {
      this.warehouseRepository = warehouseRepository;
   }

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
