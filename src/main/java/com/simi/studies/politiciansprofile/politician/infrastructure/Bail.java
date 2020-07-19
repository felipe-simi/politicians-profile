package com.simi.studies.politiciansprofile.politician.infrastructure;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Bail {

  @Id
  private UUID id;
  private BigDecimal value;
  private Instant date;
  @MapsId
  @OneToOne(fetch = FetchType.LAZY)
  private Prison prison;

}
