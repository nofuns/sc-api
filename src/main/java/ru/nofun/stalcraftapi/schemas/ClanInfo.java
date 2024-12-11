package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record ClanInfo (
        String id,
        String name,
        String tag,
        int level,
        int levelPoints,
        String registrationTime,
        String alliance,
        String description,
        String leader,
        int memberCount
)
{
    public static ClanInfo fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, ClanInfo.class);
    }
}
