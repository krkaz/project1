package com.test.farmproj.domain.warehouse.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WarehouseSnapshot {
   List<ProductInWarehouseSnapshot> productInWarehouseSnapshotList;
}
