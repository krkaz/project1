package com.test.farmproj.domain.product.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.farmproj.domain.product.dto.ProductSnapshot;
import com.test.farmproj.domain.product.entity.Product;
import com.test.farmproj.domain.product.repo.IProductRepository;

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
