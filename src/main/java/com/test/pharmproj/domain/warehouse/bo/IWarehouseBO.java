package com.test.pharmproj.domain.warehouse.bo;

public interface IWarehouseBO {

   void add(Long productId, Long quantity);

   void edit(Long productId, Long quantity);
}
