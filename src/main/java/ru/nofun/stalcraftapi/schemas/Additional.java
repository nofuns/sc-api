package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
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

}
