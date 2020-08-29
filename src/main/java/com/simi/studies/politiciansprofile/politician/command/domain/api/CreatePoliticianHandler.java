package com.simi.studies.politiciansprofile.politician.command.domain.api;

import com.simi.studies.politiciansprofile.politician.command.domain.AddressCommand;
import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import com.simi.studies.politiciansprofile.politician.command.domain.CommandResponse;
import com.simi.studies.politiciansprofile.politician.command.domain.CreatePoliticianCommand;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Address;
import com.simi.studies.politiciansprofile.politician.command.domain.model.AddressType;
import com.simi.studies.politiciansprofile.politician.command.domain.model.Politician;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePoliticianHandler
    implements CommandHandler<CreatePoliticianCommand, Politician> {

  private final PoliticianFactory factory;

  @Override
  public CommandResponse<Politician> execute(final Command<CreatePoliticianCommand> createCommand) {
    final var command = createCommand.getPayload();
    final var documentType = command.getDocumentType();
    final var documentCode = command.getDocumentCode();
    try {
      final var address = mapToAddress(command.getAddress());
      return CommandResponse
          .success(factory.create(new Politician(documentCode, documentType, address).getId()));
    } catch (Throwable t) {
      return CommandResponse.failed(t);
    }
  }

  private Address mapToAddress(final AddressCommand address) {
    return Address.builder()
        .withType(AddressType.valueOf(address.getType()))
        .withStreet(address.getStreet())
        .withNumber(address.getNumber())
        .withComplement(address.getComplement())
        .withNeighborhood(address.getNeighborhood())
        .withRegion(address.getRegion())
        .withPostalCode(address.getPostalCode())
        .withCountry(address.getCountry())
        .build();
  }

}
