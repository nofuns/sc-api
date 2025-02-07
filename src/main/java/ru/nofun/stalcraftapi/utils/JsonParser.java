package ru.nofun.stalcraftapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonParser {
    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(json, tClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
