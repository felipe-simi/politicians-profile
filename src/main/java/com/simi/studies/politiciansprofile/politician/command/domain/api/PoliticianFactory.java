package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;

@FunctionalInterface
public interface PoliticianFactory {

  Politician create(final String documentCode, final String documentType, final String name);

}
