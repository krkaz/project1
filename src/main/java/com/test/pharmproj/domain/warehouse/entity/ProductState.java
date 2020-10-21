package com.test.pharmproj.domain.warehouse.entity;

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
public class ProductState
      implements Serializable {

   private Long productId;

   @Min(0)
   private Long quantity;

   protected ProductState() {}
}
