package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record CharacterProfileData(
        String username,
        String uuid,
        String status,
        String alliance,
        String lastLogin,
        ClanInfo clan
)
{
    public static CharacterProfileData fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, CharacterProfileData.class);
    }
}