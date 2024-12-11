package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record CharacterClanInfo(
        ClanInfo info,
        ClanMember member
)
{
    public static CharacterClanInfo fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, CharacterClanInfo.class);
    }
}
