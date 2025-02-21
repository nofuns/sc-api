package ru.nofun.stalcraftapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonParser {
    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
