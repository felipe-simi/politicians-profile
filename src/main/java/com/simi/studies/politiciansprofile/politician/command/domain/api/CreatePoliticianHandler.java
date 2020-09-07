package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import com.simi.studies.politiciansprofile.politician.command.domain.CommandResponse;
import com.simi.studies.politiciansprofile.politician.command.domain.CreatePoliticianCommand;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePoliticianHandler implements CreatePoliticianClient {

  private final PoliticianFactory factory;

  @Override
  public CommandResponse<Politician> execute(final Command<CreatePoliticianCommand> createCommand) {
    final var command = createCommand.getPayload();
    final var documentType = command.getDocumentType();
    final var documentCode = command.getDocumentCode();
    final var name = command.getName();
    try {
      return CommandResponse.success(factory.create(documentCode, documentType, name));
    } catch (Throwable t) {
      return CommandResponse.failed(t);
    }
  }

}
