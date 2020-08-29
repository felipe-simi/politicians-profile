package com.simi.studies.politiciansprofile.politician.command.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class AddressCommand {

  private final String type;
  private final String postalCode;
  private final String street;
  private final String number;
  private final String complement;
  private final String neighborhood;
  private final String region;
  private final String country;

  public AddressCommand(final String type,
                        final String postalCode,
                        final String street,
                        final String number, String complement, String neighborhood,
                        final String region,
                        final String country) {
    this.type = type;
    this.postalCode = postalCode;
    this.street = street;
    this.number = number;
    this.complement = complement;
    this.neighborhood = neighborhood;
    this.region = region;
    this.country = country;
  }

}
