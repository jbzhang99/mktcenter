package com.bizvane.mktcenterfacade.models.bo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ActivityEvaluationBO {

  @NotBlank
  private String memberCode;
  
  @NotNull
  private Long brandId;
}
