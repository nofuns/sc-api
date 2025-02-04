package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ClanListResponse(
    int totalClans,
    ArrayList<ClanInfo> data
)
{
    public static ClanListResponse fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, ClanListResponse.class);
    }
}
