package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Additional(
    @JsonSetter("qlt")
    int quality,

    @JsonSetter("ptn")
    int potential,

    @JsonSetter("upgrade_bonus")
    double upgradeBonus,

    @JsonSetter("spawn_time")
    long spawnTime,

    @JsonSetter("bonus_properties")
    ArrayList<String> bonusProperties,

    @JsonSetter("it_transf_count")
    int itemTransfersCount,

    String buyer
) {
    public static Additional fromJson(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Additional.class);
    }
}
