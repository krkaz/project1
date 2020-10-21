package com.test.pharmproj.domain.warehouse.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.pharmproj.domain.product.entity.Product;
import com.test.pharmproj.domain.product.repo.IProductRepository;
import com.test.pharmproj.domain.warehouse.entity.Warehouse;
import com.test.pharmproj.domain.warehouse.repo.IWarehouseRepository;

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
      if (warehouseRepository.findByProductId(productId) != null) {
         throw new RuntimeException("Cannot add new product, because it already exists");
      }

      Optional<Product> product = productRepository.findById(productId);

      if (!product.isPresent()) {
         throw new RuntimeException("Cannot find product by id");
      }

      Warehouse warehouse = new Warehouse(product.get(), quantity);
      warehouseRepository.saveAndFlush(warehouse);
   }

   @Override
   public void edit(Long productId, Long quantity) {
      Warehouse warehouse = warehouseRepository.findByProductId(productId);

      if (warehouse == null) {
         throw new RuntimeException("Cannot edit product quantity, because cannot find product by id");
      }

      warehouse.setQuantity(quantity);
      warehouseRepository.saveAndFlush(warehouse);
   }
}
