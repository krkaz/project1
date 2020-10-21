package com.test.pharmproj.domain.product.finder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.pharmproj.domain.product.dto.ProductSnapshot;
import com.test.pharmproj.domain.product.entity.Product;
import com.test.pharmproj.domain.product.repo.IProductRepository;

@Component
@Transactional(readOnly = true,
      propagation = Propagation.SUPPORTS)
public class ProductSnapshotFinder implements IProductSnapshotFinder {

   private final IProductRepository productRepository;

   @Autowired
   public ProductSnapshotFinder(IProductRepository productRepository) {
      this.productRepository = productRepository;
   }

   @Override
   public ProductSnapshot findById(Long id) {
      Optional<Product> product = productRepository.findById(id);
      return product.map(Product::toSnapshot)
                 .orElse(null);
   }

   @Override
   public ProductSnapshot findByName(String name) {
      Optional<Product> product = productRepository.findByName(name);
      return product.map(Product::toSnapshot)
                    .orElse(null);
   }

   @Override
   public List<ProductSnapshot> findAll() {
      return productRepository.findAll()
            .stream()
            .map(Product::toSnapshot)
            .collect(Collectors.toList());
   }
}
