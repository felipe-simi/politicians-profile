package com.simi.studies.politiciansprofile.politician.infrastructure;

import lombok.Value;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Value
@Embeddable
public class DocumentId implements Serializable {

  private static final long serialVersionUID = -5851994620530868508L;

  private String documentCode;
  private String documentType;

}
