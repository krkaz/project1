package com.test.farmproj.web.restapi.warehouse;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.farmproj.domain.warehouse.bo.IWarehouseBO;
import com.test.farmproj.domain.warehouse.finder.IWarehouseSnapshotFinder;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseApi {

   private final IWarehouseSnapshotFinder warehouseSnapshotFinder;
   private final IWarehouseBO warehouseBO;

   @Autowired
   public WarehouseApi(IWarehouseSnapshotFinder warehouseSnapshotFinder, IWarehouseBO warehouseBO) {
      this.warehouseSnapshotFinder = warehouseSnapshotFinder;
      this.warehouseBO = warehouseBO;
   }

   @GetMapping
   ResponseEntity<ProductStateResponse> getAll() {
      ProductStateResponse productStateResponse = new ProductStateResponse(warehouseSnapshotFinder.findAll());
      return ResponseEntity.ok(productStateResponse);
   }

   @GetMapping(path = "/search/{productId}")
   ResponseEntity<ProductState> search(@PathVariable Long productId) {
      ProductState productState = new ProductState(warehouseSnapshotFinder.findById(productId));
      return ResponseEntity.ok(productState);
   }

   @PostMapping
   ResponseEntity<ProductState> add(@Valid @RequestBody NewProductState newProductState) {
      warehouseBO.add(newProductState.getProductId(), newProductState.getQuantity());

      return ResponseEntity.ok().build();
   }

   @PutMapping(path = "/edit/product/{productId}/quantity/{quantity}")
   ResponseEntity<ProductState> editQuantity(@PathVariable Long productId, @PathVariable Long quantity) {
      warehouseBO.edit(productId, quantity);
      return ResponseEntity.ok().build();
   }
}
