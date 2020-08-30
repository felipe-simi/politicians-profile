package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
public class PoliticianDbo {

  @Valid
  @NotNull
  @EmbeddedId
  private DocumentIdDbo id;
  @Valid
  @Embedded
  private AddressDbo address;
  @OneToMany(
      mappedBy = "politician",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<SocialNetworkDbo> socialNetworks = Collections.emptySet();
  @OneToMany(
      mappedBy = "politician",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<PrisonDbo> prisons = Collections.emptySet();

}
