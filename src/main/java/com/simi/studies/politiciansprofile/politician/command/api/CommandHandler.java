package com.simi.studies.politiciansprofile.politician.command.api;

import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import com.simi.studies.politiciansprofile.politician.command.domain.CommandResponse;

public interface CommandHandler<T, U> {

  CommandResponse<U> execute(final Command<T> command);

}
