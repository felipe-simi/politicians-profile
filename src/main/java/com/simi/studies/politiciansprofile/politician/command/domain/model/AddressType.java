package com.simi.studies.politiciansprofile.politician.command.domain.model;

import java.util.Optional;

public enum AddressType {

  RESIDENTIAL("residential"), COMMERCIAL("commercial");

  private final String type;

  AddressType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public Optional<AddressType> getDocumentType(String value) {
    for (AddressType addressType : AddressType.values()) {
      if (addressType.type.equalsIgnoreCase(value)) {
        return Optional.of(addressType);
      }
    }
    return Optional.empty();
  }

}
