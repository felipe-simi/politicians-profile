package com.simi.studies.politiciansprofile.politician.command.domain.model;

import java.util.Optional;

public enum DocumentType {

  CPF("cpf"), RG("rg");

  private String type;

  DocumentType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public Optional<DocumentType> getDocumentType(String value) {
    for (DocumentType documentType : DocumentType.values()) {
      if (documentType.type.equalsIgnoreCase(value)) {
        return Optional.of(documentType);
      }
    }
    return Optional.empty();
  }

}
