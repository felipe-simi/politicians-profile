package com.simi.studies.politiciansprofile.politician.command.domain;

import lombok.Builder;
import lombok.Getter;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
public class CreatePoliticianCommand {

  @NotNull
  private UUID id;
  @NotBlank
  private String documentType;
  @NotBlank
  private String documentCode;
  @Valid
  private AddressCommand address;

  public CreatePoliticianCommand(@NotNull UUID id,
                                 @NotBlank String documentType,
                                 @NotBlank String documentCode,
                                 @Valid AddressCommand address) {
    this.id = id;
    this.documentType = documentType;
    this.documentCode = documentCode;
    this.address = address;
  }
}
