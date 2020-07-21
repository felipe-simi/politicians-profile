package com.simi.studies.politiciansprofile.politician.command.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.Collections;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Politician {

  private DocumentId id;
  private Address address;
  private Set<SocialNetwork> socialNetworks = Collections.emptySet();
  private Set<Prison> prisons = Collections.emptySet();

  public void setAddress(Address address) {
    this.address = address;
  }

  public boolean addSocialNetwork(final SocialNetwork socialNetwork) {
    if (socialNetwork != null && notEmptyString(socialNetwork.getLink())
        && notEmptyString(socialNetwork.getName())) {
      return socialNetworks.add(socialNetwork);
    }
    return false;
  }

  public boolean removeSocialNetwork(final SocialNetwork socialNetwork) {
    if (socialNetwork != null && notEmptyString(socialNetwork.getLink())
        && notEmptyString(socialNetwork.getName())) {
      return socialNetworks.remove(socialNetwork);
    }
    return false;
  }

  public boolean addPrison(final Prison prison) {
    if (prison != null && prison.getDate() != null) {
      return prisons.add(prison);
    }
    return false;
  }

  public boolean removePrison(final Prison prison) {
    if (prison != null && prison.getDate() != null) {
      return prisons.remove(prison);
    }
    return false;
  }

  private boolean notEmptyString(String string) {
    return (string != null && !string.isBlank());
  }

}
