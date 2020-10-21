package com.test.pharmproj.web.restapi.warehouse;

import com.test.pharmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel
@Getter
public class ProductState {

   @ApiModelProperty(value = "unique identifier of product",
         required = true,
         position = 1)
   private final Long id;
   @ApiModelProperty(value = "name of product",
         required = true,
         position = 2)
   private final String name;
   @ApiModelProperty(value = "quantity of product in Warehouse",
         required = true,
         position = 3)
   private final Long quantity;

   public ProductState(ProductInWarehouseSnapshot product) {
      this.id = product.getProduct().getId();
      this.name = product.getProduct().getName();
      this.quantity = product.getQuantity();
   }
}
