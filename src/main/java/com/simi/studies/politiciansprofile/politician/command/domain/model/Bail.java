package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Value;
import java.math.BigDecimal;
import java.time.Instant;

@Value
public class Bail {

  private final BigDecimal value;
  private final Instant date;

}
