package com.simi.studies.politiciansprofile.politician.infrastructure;

import lombok.Data;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class Politician {

  @EmbeddedId
  private DocumentId id;
  @Embedded
  private Address address;

}
