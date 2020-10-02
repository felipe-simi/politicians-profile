package com.simi.studies.politiciansprofile.politician.command.infrastructure.kafka;

import com.simi.studies.politiciansprofile.politician.command.domain.Command;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CreatePoliticianListener {

  @KafkaListener(groupId = "politiciansService", topics = "politician_created")
  public void listener(Command data) {
    System.out.println("politician_created message recieved: " + data.getId());
    System.out.println("politician_created message recieved: " + data.getRequestedIn());
    System.out.println("politician_created message recieved: " + data.getPayload());
  }

}
