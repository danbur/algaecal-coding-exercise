package com.example.algaecal.utilities;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Locale;
import java.util.Map;

/** Needed to convert Cucumber data tables to lists of objects */
public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
  @Override
  public void configureTypeRegistry(TypeRegistry registry) {

    JacksonTableTransformer jacksonTableTransformer = new JacksonTableTransformer();
    registry.setDefaultDataTableEntryTransformer(jacksonTableTransformer);
    registry.setDefaultDataTableCellTransformer(jacksonTableTransformer);
  }

  @Override
  public Locale locale() {
    return Locale.ENGLISH;
  }

  private static final class JacksonTableTransformer
      implements TableEntryByTypeTransformer, TableCellByTypeTransformer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T transform(
        Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) {
      return objectMapper.convertValue(entry, type);
    }

    @Override
    public <T> T transform(String value, Class<T> cellType) {
      return objectMapper.convertValue(value, cellType);
    }
  }
}
