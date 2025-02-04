package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ClanMember(
    String name,
    String rank,
    String joinTime
) {
    public static ClanMember fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, ClanMember.class);
    }
}
