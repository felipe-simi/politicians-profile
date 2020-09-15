package com.simi.studies.politiciansprofile.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final ClassLoader classLoader = this.getClass().getClassLoader();
  private Class<?> argumentsType;
  private String[] resources;

  @Override
  public void accept(final JsonSource jsonSource) {
    this.argumentsType = jsonSource.argumentsType();
    this.resources = jsonSource.resources();
  }

  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
    return Stream.of(resources)
        .map(this::fromPathAsString)
        .map(convertToObject())
        .map(object -> Arguments.of(object));
  }

  private String fromPathAsString(final String fileName) {
    try {
      var fileUrl = classLoader.getResource(fileName).toURI();
      return Files.lines(Path.of(fileUrl))
          .collect(Collectors.joining(""));
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  private Function<String, ?> convertToObject() {
    return body -> {
      try {
        return objectMapper.readValue(body, argumentsType);
      } catch (JsonProcessingException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    };
  }

}
