package com.test.farmproj.domain.warehouse.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class WarehouseState implements Serializable {

   private Long productId;
//   private Long warehouseId;

   @Min(0)
   private Long quantity;

   protected WarehouseState() {}
}
