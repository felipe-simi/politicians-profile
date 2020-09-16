package com.simi.studies.politiciansprofile.unit;

import com.simi.studies.politiciansprofile.politician.command.client.CreatePoliceRequestBody;
import com.simi.studies.politiciansprofile.util.JsonSource;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonSourceTest {

  @ParameterizedTest
  @JsonSource(resources = "politicians/valid_politician.json")
  void givenNoArgumentsType_WhenParameterizedTest_ThenShouldFillAsMap(final Map politician) {
    final var expectedPolitician = Map.of("documentCode", "12345678",
        "documentType", "RG",
        "name", "Valid Name");
    assertAll("Can read politician from JSON file",
        () -> assertEquals(expectedPolitician.get("documentCode"), politician.get("documentCode")),
        () -> assertEquals(expectedPolitician.get("documentType"), politician.get("documentType")),
        () -> assertEquals(expectedPolitician.get("name"), politician.get("name")));
  }

  @ParameterizedTest
  @JsonSource(argumentsType = CreatePoliceRequestBody.class, resources = "politicians/valid_politician.json")
  void givenArgumentsType_WhenParameterizedTest_ThenShouldFillAsObject(
      final CreatePoliceRequestBody requestBody) {
    final var expectedPolitician = Map.of("documentCode", "12345678",
        "documentType", "RG",
        "name", "Valid Name");
    assertAll("Can read politician from JSON file",
        () -> assertEquals(expectedPolitician.get("documentCode"), requestBody.getDocumentCode()),
        () -> assertEquals(expectedPolitician.get("documentType"), requestBody.getDocumentType()),
        () -> assertEquals(expectedPolitician.get("name"), requestBody.getName()));
  }

}
