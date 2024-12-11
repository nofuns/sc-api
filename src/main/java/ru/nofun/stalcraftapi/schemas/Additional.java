package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Additional(
        int qlt,
        int ptn,
        double upgrade_bonus,
        long spawn_time,
        ArrayList<String> bonus_properties,
        double ndmg,
        int it_transf_count
)
{
    public static Additional fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Additional.class);
    }
}
