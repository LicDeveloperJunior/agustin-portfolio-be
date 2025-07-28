package com.agustincollueque.portfolio.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Agustin Collueque
 */
@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> lista) {
        if (lista == null || lista.isEmpty()) {
            return "";
        }
        return String.join(SEPARATOR, lista);
    }

    @Override
    public List<String> convertToEntityAttribute(String datos) {
        if (datos == null || datos.isBlank()) {
            return Collections.emptyList();
        }
        return Arrays.stream(datos.split(SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

