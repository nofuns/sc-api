package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record EmissionResponse (
    String currentStart,
    String previousStart,
    String previousEnd
) {

}