package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Value;
import java.math.BigDecimal;
import java.time.Instant;

@Value
public class Bail {

  private BigDecimal value;
  private Instant date;

}
