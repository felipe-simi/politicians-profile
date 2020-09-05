package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.CommandResponse;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;

@FunctionalInterface
public interface CreatePoliticianClient {

  CommandResponse<Politician> createPolitician(final CreatePoliticianDto createPoliticianDto);

}
