package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Politician {

  private final DocumentId id;
  private final String name;
  private String nickname;

}
