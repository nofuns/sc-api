package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public record PricesListing (
        long total,
        ArrayList<PriceEntry> prices
)
{
    public static PricesListing fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, PricesListing.class);
    }
}