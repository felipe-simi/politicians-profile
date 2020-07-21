package com.simi.studies.politiciansprofile.politician.command.domain;

import com.simi.studies.politiciansprofile.politician.command.domain.model.Address;
import com.simi.studies.politiciansprofile.politician.command.domain.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreatePoliticianCommand {

  private UUID id;
  private DocumentType documentType;
  private Address address;

}
