package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FullCharacterInfo(
        CharacterMetaInfo info,
        CharacterClanInfo clan
)
{
    public static FullCharacterInfo fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, FullCharacterInfo.class);
    }
}
