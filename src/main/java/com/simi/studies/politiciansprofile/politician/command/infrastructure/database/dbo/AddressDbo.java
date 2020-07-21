package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AddressDbo implements Serializable {

  private static final long serialVersionUID = -3246659507940145548L;

  private String addressType;
  private String postalCode;
  private String street;
  private String number;
  private String complement;
  private String neighborhood;
  private String region;
  private String country;

}
