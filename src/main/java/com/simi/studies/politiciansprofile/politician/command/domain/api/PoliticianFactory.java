package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.model.Address;
import com.simi.studies.politiciansprofile.politician.command.domain.model.DocumentId;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;

public interface PoliticianFactory {

  Politician create(final DocumentId id);

  Politician create(final DocumentId id, final Address address);

}
