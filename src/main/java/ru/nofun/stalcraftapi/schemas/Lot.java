package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Lot (
    String itemId,
    int amount,
    long startPrice,
    long currentPrice,
    long buyoutPrice,
    String startTime,
    String endTime,
    Additional additional
) {

}