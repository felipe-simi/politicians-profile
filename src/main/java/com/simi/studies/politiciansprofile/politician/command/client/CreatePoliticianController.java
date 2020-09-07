package com.simi.studies.politiciansprofile.politician.command.client;

import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import com.simi.studies.politiciansprofile.politician.command.domain.CreatePoliticianCommand;
import com.simi.studies.politiciansprofile.politician.command.domain.api.CreatePoliticianClient;
import com.simi.studies.politiciansprofile.politician.command.domain.api.CreatePoliticianHandler;
import com.simi.studies.politiciansprofile.politician.command.domain.api.PoliticianFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.UUID;

@RestController
public class CreatePoliticianController {

  private final CreatePoliticianClient client;

  public CreatePoliticianController(final PoliticianFactory politicianFactory) {
    this.client = new CreatePoliticianHandler(politicianFactory);
  }

  @PostMapping
  public ResponseEntity handleCreatePoliticianRequest(@Valid final CreatePoliceRequestBody body) {

    final var createPoliticianCommand = mapToCommand(body);
    final var commandResponse = client.execute(createPoliticianCommand);
    if (commandResponse.isSuccessfully()) {
      return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  private Command mapToCommand(final CreatePoliceRequestBody body) {
    final var commandId = UUID.randomUUID();
    final var command = CreatePoliticianCommand.builder()
        .documentCode(body.getDocumentCode())
        .documentType(body.getDocumentType())
        .name(body.getName())
        .build();
    return new Command(commandId, command);
  }


}
