package com.test.farmproj.web.restapi.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "body",
      description = "Comment object that needs to be added to system")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewProduct {

   @NotBlank
   @Size(min = 3, max = 256)
   private String name;
}
