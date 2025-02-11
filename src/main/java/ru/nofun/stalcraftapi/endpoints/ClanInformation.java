package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.ClanInfo;

public class ClanInformation implements ApiMethod {
    public static final Class<ClanInfo> JSON_FORMAT = ClanInfo.class;

    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String clanId;

    public ClanInformation(String clanId) {
        this.clanId = clanId;
    }

    public String get() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, clanId);
    }
}
