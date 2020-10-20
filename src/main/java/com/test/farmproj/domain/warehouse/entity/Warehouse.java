package com.test.farmproj.domain.warehouse.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.test.farmproj.domain.product.entity.Product;
import com.test.farmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;
import com.test.farmproj.domain.warehouse.dto.WarehouseSnapshot;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "warehouse_state")
public class Warehouse
      implements Serializable {

   @EmbeddedId
   private WarehouseState warehouseState;

   @ManyToOne
   @MapsId("productId")
   private Product product;

   protected Warehouse() {
   }

   public Warehouse(Product product, Long quantity) {
      this.product = product;
      this.warehouseState = new WarehouseState(product.getId(), quantity);
   }

   public ProductInWarehouseSnapshot toSnapshot() {
      return new ProductInWarehouseSnapshot(this.product.toSnapshot(), this.warehouseState.getQuantity());
   }

   public void setQuantity(Long quantity) {
      this.warehouseState.setQuantity(quantity);
   }
}
