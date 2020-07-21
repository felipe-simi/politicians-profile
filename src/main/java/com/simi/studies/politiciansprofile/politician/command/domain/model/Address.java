package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Address {

  private AddressType type;
  private String postalCode;
  private String street;
  private String number;
  private String complement;
  private String neighborhood;
  private String region;
  private String country;

}
