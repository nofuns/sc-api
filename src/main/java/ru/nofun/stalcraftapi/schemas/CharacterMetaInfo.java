package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CharacterMetaInfo(
        String id,
        String name,
        String creationTime
)
{
    public static CharacterMetaInfo fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, CharacterMetaInfo.class);
    }
}
