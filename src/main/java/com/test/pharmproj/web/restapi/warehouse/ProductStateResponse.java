package com.test.pharmproj.web.restapi.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.test.pharmproj.domain.warehouse.dto.ProductInWarehouseSnapshot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class ProductStateResponse {

   @ApiModelProperty(value = "collection of product states",
         required = true,
         position = 1)
   List<ProductState> productsStates = new ArrayList<>();

   public ProductStateResponse(List<ProductInWarehouseSnapshot> productInWarehouseSnapshot) {
      productInWarehouseSnapshot.forEach(product -> this.productsStates.add(new ProductState(product)));
   }
}
