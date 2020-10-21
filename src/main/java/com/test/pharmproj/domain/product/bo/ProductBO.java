package com.test.pharmproj.domain.product.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.pharmproj.domain.product.dto.ProductSnapshot;
import com.test.pharmproj.domain.product.entity.Product;
import com.test.pharmproj.domain.product.repo.IProductRepository;

@Service
public class ProductBO implements IProductBO {

   final IProductRepository productRepository;

   @Autowired
   public ProductBO(IProductRepository productRepository) {
      this.productRepository = productRepository;
   }

   @Override
   public ProductSnapshot add(String name) {
      Product product = new Product(name);

      product = productRepository.saveAndFlush(product);
      return product.toSnapshot();
   }
}
