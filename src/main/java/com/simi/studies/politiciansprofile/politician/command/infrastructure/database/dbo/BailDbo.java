package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "bail_test")
public class BailDbo {

  @Id
  private UUID id;
  private BigDecimal value;
  private Instant date;
  @MapsId
  @OneToOne(fetch = FetchType.LAZY)
  private PrisonDbo prison;

}
