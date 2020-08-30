package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo;

import lombok.Data;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Embeddable
public class AddressDbo implements Serializable {

  private static final long serialVersionUID = -3246659507940145548L;
  @NotBlank
  private String addressType;
  @NotBlank
  private String postalCode;
  @NotBlank
  private String street;
  @NotBlank
  private String number;
  private String complement;
  @NotBlank
  private String neighborhood;
  @NotBlank
  private String region;
  @NotBlank
  private String country;

}
