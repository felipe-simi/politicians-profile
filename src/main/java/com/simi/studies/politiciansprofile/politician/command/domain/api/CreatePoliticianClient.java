package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import com.simi.studies.politiciansprofile.politician.command.domain.CommandResponse;
import com.simi.studies.politiciansprofile.politician.command.domain.CreatePoliticianCommand;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;

@FunctionalInterface
public interface CreatePoliticianClient
    extends CommandHandler<CreatePoliticianCommand, Politician> {

  CommandResponse<Politician> execute(final Command<CreatePoliticianCommand> command);

}
