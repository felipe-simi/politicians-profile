package com.simi.studies.politiciansprofile.politician.command.domain.model;

public enum AddressType {

  RESIDENTIAL("residential"), COMMERCIAL("commercial");

  private String type;

  AddressType(String type) {
    this.type = type;
  }

}
