package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dao;

import com.simi.studies.politiciansprofile.politician.command.domain.api.PoliticianFactory;
import com.simi.studies.politiciansprofile.politician.command.domain.model.DocumentId;
import com.simi.studies.politiciansprofile.politician.command.domain.model.DocumentType;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;
import com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo.DocumentIdDbo;
import com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo.PoliticianDbo;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaPoliticianFactory implements PoliticianFactory {

  private final PoliticianSpringRepository repository;

  @Override
  @Bulkhead(name = "politicianFactory", type = Bulkhead.Type.SEMAPHORE)
  public Politician create(final String documentCode, final String documentType,
                           final String name) {
    final var type = DocumentType.getDocumentType(documentType);
    final var documentId =
        new DocumentId(documentCode, type.orElseThrow(() -> new IllegalArgumentException()));
    final var dbo = new PoliticianDbo();
    final DocumentIdDbo dboId = mapToDbo(documentId);
    dbo.setId(dboId);
    repository.save(dbo);
    return Politician.builder()
        .withId(documentId)
        .withName(name)
        .build();
  }

  private DocumentIdDbo mapToDbo(final DocumentId id) {
    final var dboId = new DocumentIdDbo();
    dboId.setDocumentCode(id.getDocumentCode());
    dboId.setDocumentType(id.getDocumentType().getType());
    return dboId;
  }

}
