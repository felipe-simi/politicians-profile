package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import com.simi.studies.politiciansprofile.politician.command.domain.CommandResponse;

@FunctionalInterface
public interface CommandHandler<T, U> {

  CommandResponse<U> execute(final Command<T> command);

}
