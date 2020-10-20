package com.test.farmproj.domain.warehouse.bo;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.farmproj.domain.product.entity.Product;
import com.test.farmproj.domain.product.repo.IProductRepository;
import com.test.farmproj.domain.warehouse.entity.Warehouse;
import com.test.farmproj.domain.warehouse.repo.IWarehouseRepository;

@Service
public class WarehouseBO
      implements IWarehouseBO {

   final IProductRepository productRepository;
   final IWarehouseRepository warehouseRepository;

   @Autowired
   public WarehouseBO(IProductRepository productRepository, IWarehouseRepository warehouseRepository) {
      this.productRepository = productRepository;
      this.warehouseRepository = warehouseRepository;
   }

   @Override
   public void add(Long productId, Long quantity) {
      Optional<Product> product = productRepository.findById(productId);

      product.map(prod -> {
         Warehouse warehouse = new Warehouse(prod, quantity);
         warehouse = warehouseRepository.saveAndFlush(warehouse);

         return warehouse.toSnapshot();
      }).orElseThrow(EntityNotFoundException::new);
   }

   @Override
   public void edit(Long productId, Long quantity) {
      Optional<Warehouse> warehouse = warehouseRepository.findById(productId);

      warehouse.map(warehouseEntity -> {
         warehouseEntity.setQuantity(quantity);
         warehouseEntity = warehouseRepository.saveAndFlush(warehouseEntity);

         return warehouseEntity.toSnapshot();
      }).orElseThrow(EntityNotFoundException::new);
   }
}
