package com.simi.studies.politiciansprofile.politician.command.client;

import lombok.Getter;

@Getter
public class CreatePoliceRequestBody {

  private String documentCode;
  private String documentType;
  private String name;

}
