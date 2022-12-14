package com.superkassa.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superkassa.server.model.Current;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.boot.json.JsonParseException;

@Converter(autoApply = true)
public class JsonModelConverter implements AttributeConverter<Current, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Current current) {
        try {
            return objectMapper.writeValueAsString(current);
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getMessage());
            throw new JsonParseException();
        }
    }

    @Override
    public Current convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Current.class);
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getMessage());
            throw new JsonParseException();
        }
    }
}
