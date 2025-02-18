package ru.nofun.stalcraftapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonParser {
    public static <T> T parse(String json, TypeReference<T> typeReference) {
        try {
            return new ObjectMapper().readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
