package com.simi.studies.politiciansprofile.politician.command.domain;

import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
public final class AddressCommand {

  @NotBlank
  private final String type;
  @NotBlank
  private final String postalCode;
  @NotBlank
  private String street;
  @NotBlank
  private final String number;
  private final String complement;
  private final String neighborhood;
  @NotBlank
  private final String region;
  @NotBlank
  private final String country;

  public AddressCommand(@NotBlank String type,
                        @NotBlank String postalCode,
                        @NotBlank String street,
                        @NotBlank String number, String complement, String neighborhood,
                        @NotBlank String region,
                        @NotBlank String country) {
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
