package ru.nofun.stalcraftapi.endpoints;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ClanInformation extends ApiMethod {
    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String clanId;

    @Override
    public String getPath() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, clanId);
    }
}
