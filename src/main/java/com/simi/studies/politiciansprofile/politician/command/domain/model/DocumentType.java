package com.simi.studies.politiciansprofile.politician.command.domain.model;

import java.util.Optional;

public enum DocumentType {

  CPF("cpf"), RG("rg");

  private String type;

  DocumentType(final String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static Optional<DocumentType> getDocumentType(final String value) {
    for (DocumentType documentType : DocumentType.values()) {
      if (documentType.type.equalsIgnoreCase(value)) {
        return Optional.of(documentType);
      }
    }
    return Optional.empty();
  }

}
