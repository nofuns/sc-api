package ru.nofun.stalcraftapi.endpoints;

import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.schemas.ClanInfo;


@AllArgsConstructor
public class ClanInformation extends ApiMethod<ClanInfo> {
    private static final Class<ClanInfo> jsonFormat = ClanInfo.class;
    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String clanId;

    @Override
    public String getMethod() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, clanId);
    }

    @Override
    public Class<ClanInfo> getJsonFormat() {
        return jsonFormat;
    }
}
