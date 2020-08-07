package com.simi.studies.politiciansprofile.politician.command.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.time.Instant;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public final class Command<T> {

  private final UUID id;
  private final T payload;
  private final Instant requestedIn = Instant.now();

}
