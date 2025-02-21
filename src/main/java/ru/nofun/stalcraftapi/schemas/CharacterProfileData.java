package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CharacterProfileData(
    String username,
    String uuid,
    String status,
    String alliance,
    String lastLogin,
    ClanInfo clan
) {

}
