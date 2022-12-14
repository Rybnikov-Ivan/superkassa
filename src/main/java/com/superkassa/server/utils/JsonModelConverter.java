package com.superkassa.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.superkassa.server.model.Current;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter(autoApply = true)
public class JsonModelConverter implements AttributeConverter<Current, String> {
    private static final Logger logger = LoggerFactory.getLogger(Logger.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Current current) {
        String currentJson = null;
        try {
            currentJson = objectMapper.writeValueAsString(current);
        } catch (JsonProcessingException ex) {
            logger.error("JSON writing error");
        }
        return currentJson;
    }

    @Override
    public Current convertToEntityAttribute(String s) {
        Current current = null;
        try {
            current = objectMapper.readValue(s, Current.class);
        } catch (JsonProcessingException ex) {
            logger.error("JSON reading error");
        }
        return current;
    }
}
