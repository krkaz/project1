package com.test.pharmproj.web.restapi.warehouse;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@AllArgsConstructor
@Getter
@Setter
public class NewProductState {

   @NotNull
   Long productId;

   @NotNull
   Long quantity;
}
