package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.Value;
import java.time.Instant;

@Value
public class Prison {

  private Instant date;
  private Bail bail;

}
