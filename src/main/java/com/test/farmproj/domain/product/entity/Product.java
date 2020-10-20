package com.test.farmproj.domain.product.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.test.farmproj.domain.product.dto.ProductSnapshot;
import com.test.farmproj.domain.warehouse.entity.Warehouse;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "products")
public class Product implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   @Size(min = 3,
         max = 50)
   @Column(nullable = false,
         unique = true)
   private String name;

   @OneToMany(
         mappedBy = "product",
         cascade = CascadeType.ALL,
         orphanRemoval = true
   )
   private List<Warehouse> posts = new ArrayList<>();

   protected Product() {
   }

   public Product(String name) {
      this.name = name;
   }

   public ProductSnapshot toSnapshot() {
      if (id == null) {
         throw new EntityNotFoundException();
      } else {
         return new ProductSnapshot(id, name);
      }
   }

}
