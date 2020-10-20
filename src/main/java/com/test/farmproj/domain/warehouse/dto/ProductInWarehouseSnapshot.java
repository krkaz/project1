package com.test.farmproj.domain.warehouse.dto;

import com.test.farmproj.domain.product.dto.ProductSnapshot;
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
