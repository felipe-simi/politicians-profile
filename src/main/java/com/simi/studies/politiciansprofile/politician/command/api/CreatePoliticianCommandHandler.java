package com.simi.studies.politiciansprofile.politician.command.api;

import com.simi.studies.politiciansprofile.politician.command.domain.CreatePoliticianCommand;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;

public interface CreatePoliticianCommandHandler {

  Politician handle(CreatePoliticianCommand command);

}
