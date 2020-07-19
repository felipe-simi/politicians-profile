package com.simi.studies.politiciansprofile.politician.infrastructure;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
public class Politician {

  @EmbeddedId
  private DocumentId id;
  @Embedded
  private Address address;
  @OneToMany(
      mappedBy = "politician",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<SocialNetwork> socialNetworks = Collections.emptySet();
  @OneToMany(
      mappedBy = "politician",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<Prison> prisons = Collections.emptySet();

}
