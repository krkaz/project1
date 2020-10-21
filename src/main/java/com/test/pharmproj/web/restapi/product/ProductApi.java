package com.test.pharmproj.web.restapi.product;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.pharmproj.domain.product.bo.IProductBO;
import com.test.pharmproj.domain.product.dto.ProductSnapshot;
import com.test.pharmproj.domain.product.finder.IProductSnapshotFinder;

@RestController
@RequestMapping("/api/products")
public class ProductApi {

   private final IProductSnapshotFinder productSnapshotFinder;

   private final IProductBO productBO;

   @Autowired
   public ProductApi(IProductSnapshotFinder productSnapshotFinder, IProductBO productBO) {
      this.productSnapshotFinder = productSnapshotFinder;
      this.productBO = productBO;
   }

   @GetMapping
   ResponseEntity<List<ProductResponse>> getAll() {
      return ResponseEntity.ok(productSnapshotFinder.findAll()
            .stream()
            .map(ProductResponse::new)
            .collect(Collectors.toList()));
   }

   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
   ResponseEntity<ProductResponse> add(@Valid @RequestBody NewProduct newProduct) {
      ProductSnapshot productSnapshot = productBO.add(newProduct.getName());

      return ResponseEntity.ok(new ProductResponse(productSnapshot));
   }

   @GetMapping(path = "/search")
   ResponseEntity<ProductResponse> getById(@PathParam("id") Long id, @PathParam("name") String name) {
      ProductSnapshot productSnapshot = null;
      if (id != null) {
         productSnapshot = productSnapshotFinder.findById(id);
      } else if (name != null) {
         productSnapshot = productSnapshotFinder.findByName(name);
      }

      if (productSnapshot == null) {
         return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(new ProductResponse(productSnapshot));

   }
}
