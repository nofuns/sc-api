package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record PriceEntry (
        int amount,
        long price,
        String time,
        Additional additional
)
{
    public static PriceEntry fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, PriceEntry.class);
    }
}
