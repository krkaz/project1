package com.test.farmproj.web.restapi.product;

import com.test.farmproj.domain.product.dto.ProductSnapshot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@AllArgsConstructor
@Setter
@Getter
public class ProductResponse {

   @ApiModelProperty(value = "unique identifier of Warehouse",
         required = true,
         position = 1)
   private final Long id;
   @ApiModelProperty(value = "name of Warehouse",
         required = true,
         position = 2)
   private final String name;

   public ProductResponse(ProductSnapshot productSnapshot) {
      this.id = productSnapshot.getId();
      this.name = productSnapshot.getName();
   }
}
