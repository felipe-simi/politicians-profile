package com.simi.studies.politiciansprofile.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

  private final ClassLoader classLoader = this.getClass().getClassLoader();
  private Class<?> argumentsType;
  private String[] resources;

  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
    return null;
  }

  @Override
  public void accept(final JsonSource jsonSource) {
    this.argumentsType = jsonSource.argumentsType();
    this.resources = jsonSource.resources();
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

}
