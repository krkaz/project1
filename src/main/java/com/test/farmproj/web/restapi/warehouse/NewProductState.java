package com.test.farmproj.web.restapi.warehouse;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@AllArgsConstructor
@Getter
@Setter
public class NewProductState {

   Long productId;
   Long quantity;
}
