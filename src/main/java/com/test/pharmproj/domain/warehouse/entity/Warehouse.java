package com.test.pharmproj.domain.warehouse.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.test.pharmproj.domain.product.entity.Product;
import com.test.pharmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "warehouse_state")
public class Warehouse
      implements Serializable {

   @EmbeddedId
   private ProductState productState;

   @ManyToOne
   @MapsId("productId")
   private Product product;

   protected Warehouse() {
   }

   public Warehouse(Product product, Long quantity) {
      this.product = product;
      this.productState = new ProductState(product.getId(), quantity);
   }

   public ProductInWarehouseSnapshot toSnapshot() {
      return new ProductInWarehouseSnapshot(this.product.toSnapshot(), this.productState.getQuantity());
   }

   public void setQuantity(Long quantity) {
      this.productState.setQuantity(quantity);
   }
}
