package com.simi.studies.politiciansprofile.politician.command.domain.api;

import lombok.Getter;

@Getter
public class CreatePoliticianDto {

  private String documentCode;
  private String documentType;
  private String name;
  private String nickname;


}
