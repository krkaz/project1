package com.test.farmproj.domain.warehouse.bo;

public interface IWarehouseBO {

   void add(Long productId, Long quantity);

   void edit(Long productId, Long quantity);
}
