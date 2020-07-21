package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Value;

@Value
public class DocumentId {

  private String documentCode;
  private DocumentType documentType;

}
