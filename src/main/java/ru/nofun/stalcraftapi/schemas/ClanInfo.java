package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ClanInfo (
    String id,
    String name,
    String tag,
    int level,
    int levelPoints,
    String registrationTime,
    String alliance,
    String description,
    String leader,
    int memberCount
) {

}
