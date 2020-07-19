package com.simi.studies.politiciansprofile.politician.infrastructure;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class SocialNetwork {

  @Id
  private UUID id;
  private String name;
  private String link;
  @ManyToOne(fetch = FetchType.LAZY)
  private Politician politician;

}
