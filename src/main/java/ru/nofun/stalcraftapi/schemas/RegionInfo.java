package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RegionInfo (
    String id,
    String name
)
{
    public static RegionInfo fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, RegionInfo.class);
    }
}
