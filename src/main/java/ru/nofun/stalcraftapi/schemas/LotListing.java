package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public record LotListing (
        long total,
        ArrayList<Lot> lots
)
{
    public static LotListing fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, LotListing.class);
    }
}
