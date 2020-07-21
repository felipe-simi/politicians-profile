package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class DocumentIdDbo implements Serializable {

  private static final long serialVersionUID = -5851994620530868508L;

  private String documentCode;
  private String documentType;

}
