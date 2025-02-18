package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.schemas.ClanInfo;


@AllArgsConstructor
public class ClanInformation extends ApiMethod<ClanInfo> {
    private static final TypeReference<ClanInfo> jsonFormat = new TypeReference<>() {};
    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String clanId;

    @Override
    public String getMethod() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, clanId);
    }

    @Override
    public TypeReference<ClanInfo> getJsonFormat() {
        return jsonFormat;
    }
}
