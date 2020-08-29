package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Builder(setterPrefix = "with")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Politician {

  private final DocumentId id;
  private final Address address;
  private final Set<SocialNetwork> socialNetworks = new HashSet<>();
  private final Set<Prison> prisons = new HashSet<>();

  public Politician(final String documentCode, final String documentType, final Address address) {
    Optional<DocumentType> type = DocumentType.getDocumentType(documentType);
    this.id = new DocumentId(documentCode, type.orElseThrow(() -> new IllegalArgumentException()));
    this.address = address;
  }

  public void addSocialNetwork(final SocialNetwork socialNetwork) {
    if (notEmptyString(socialNetwork.getLink()) && notEmptyString(socialNetwork.getName())) {
      socialNetworks.add(socialNetwork);
    }
  }

  public void removeSocialNetwork(final SocialNetwork socialNetwork) {
    if (notEmptyString(socialNetwork.getLink()) && notEmptyString(socialNetwork.getName())) {
      socialNetworks.remove(socialNetwork);
    }
  }

  public void addPrison(final Prison prison) {
    if (prison != null && prison.getDate() != null) {
      prisons.add(prison);
    }
  }

  public void removePrison(final Prison prison) {
    if (prison != null && prison.getDate() != null) {
      prisons.remove(prison);
    }
  }

  private boolean notEmptyString(String string) {
    return (string != null && !string.isBlank());
  }

  public DocumentId getId() {
    return id;
  }

}
