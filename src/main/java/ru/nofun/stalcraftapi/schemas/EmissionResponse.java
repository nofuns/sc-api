package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(ignoreUnknown = true)
public record EmissionResponse (
    String currentStart,
    String previousStart,
    String previousEnd
)
{
    public static EmissionResponse fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, EmissionResponse.class);
    }
}