package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CharacterMetaInfo(
    String id,
    String name,
    String creationTime
) {

}
