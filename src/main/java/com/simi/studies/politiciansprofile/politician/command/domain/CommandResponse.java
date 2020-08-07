package com.simi.studies.politiciansprofile.politician.command.domain;

import lombok.Getter;
import java.time.Instant;
import java.util.Optional;

@Getter
public class CommandResponse<T> {

  private final Optional<T> data;
  private final Optional<Throwable> error;
  private final Instant executedIn = Instant.now();

  private CommandResponse(T data) {
    this.data = Optional.of(data);
    this.error = Optional.empty();
  }

  private CommandResponse(Throwable error) {
    this.data = Optional.empty();
    this.error = Optional.of(error);
  }

  public static <T> CommandResponse<T> success(T result) {
    return new CommandResponse<>(result);
  }

  public static <T> CommandResponse<T> failed(Throwable error) {
    return new CommandResponse<>(error);
  }

  public Boolean isSuccessfully() {
    return error.isEmpty();
  }

}