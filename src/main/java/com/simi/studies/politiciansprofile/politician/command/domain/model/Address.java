package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(setterPrefix = "with")
public class Address {

  private final AddressType type;
  private final String postalCode;
  private final String street;
  private final String number;
  private final String complement;
  private final String neighborhood;
  private final String region;
  private final String country;

}
