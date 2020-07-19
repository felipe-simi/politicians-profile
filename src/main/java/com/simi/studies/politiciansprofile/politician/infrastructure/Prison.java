package com.simi.studies.politiciansprofile.politician.infrastructure;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Prison {

  @Id
  private UUID id;
  private Instant date;
  @OneToOne(mappedBy = "prison", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  private Bail bail;
  @ManyToOne(fetch = FetchType.LAZY)
  private Politician politician;

}
