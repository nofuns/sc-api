package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Lot (
    String itemId,
    int amount,
    long startPrice,
    long currentPrice,
    long buyoutPrice,
    String startTime,
    String endTime,
    Additional additional
) {
    public static Lot fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Lot.class);
    }
}