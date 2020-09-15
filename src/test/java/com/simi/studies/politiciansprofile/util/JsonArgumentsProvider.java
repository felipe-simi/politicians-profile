package com.simi.studies.politiciansprofile.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

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
  
}
