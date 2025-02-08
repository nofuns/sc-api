package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceEntry (
    int amount,
    long price,
    String time,
    Additional additional
) {

}
