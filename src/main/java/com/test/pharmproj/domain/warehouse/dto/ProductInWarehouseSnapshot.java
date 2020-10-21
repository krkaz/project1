package com.test.pharmproj.domain.warehouse.dto;

import com.test.pharmproj.domain.product.dto.ProductSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductInWarehouseSnapshot {

   ProductSnapshot product;
   Long quantity;
}
