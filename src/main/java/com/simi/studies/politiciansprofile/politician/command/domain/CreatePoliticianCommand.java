package com.simi.studies.politiciansprofile.politician.command.domain;

import lombok.Builder;
import lombok.Getter;
import java.util.UUID;

@Getter
@Builder
public class CreatePoliticianCommand {

  private UUID id;
  private String documentType;
  private String documentCode;
  private String name;

  public CreatePoliticianCommand(final UUID id,
                                 final String documentType,
                                 final String documentCode,
                                 final String name) {
    this.id = id;
    this.documentType = documentType;
    this.documentCode = documentCode;
    this.name = name;
  }
}
