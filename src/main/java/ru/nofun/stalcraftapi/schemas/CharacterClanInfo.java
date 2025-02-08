package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record CharacterClanInfo(
    ClanInfo info,
    ClanMember member
) {

}
