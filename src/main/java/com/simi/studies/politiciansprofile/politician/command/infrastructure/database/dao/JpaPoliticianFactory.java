package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dao;

import com.simi.studies.politiciansprofile.politician.command.api.PoliticianFactory;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Address;
import com.simi.studies.politiciansprofile.politician.command.domain.model.DocumentId;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;
import com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo.DocumentIdDbo;
import com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo.PoliticianDbo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaPoliticianFactory implements PoliticianFactory {

  private final PoliticianSpringRepository repository;

  @Override
  public Politician create(final DocumentId id) {
    final var dbo = new PoliticianDbo();
    final DocumentIdDbo dboId = mapToDbo(id);
    dbo.setId(dboId);
    repository.save(dbo);
    return Politician.builder()
        .withId(id)
        .build();
  }

  private DocumentIdDbo mapToDbo(final DocumentId id) {
    final var dboId = new DocumentIdDbo();
    dboId.setDocumentCode(id.getDocumentCode());
    dboId.setDocumentType(id.getDocumentType().getType());
    return dboId;
  }

  @Override
  public Politician create(DocumentId id, Address address) {
    return null;
  }

}
