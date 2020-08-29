package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Data;

@Data
public class DocumentId {

  private final String documentCode;
  private final DocumentType documentType;

}
