package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.api.ApiResponse;
import ru.nofun.stalcraftapi.schemas.ClanInfo;


public class Clans {
    private static final String CLANS_ENDPOINT_FORMAT = "/%s/clan/%s/info";

    private final Api api;
    private final Region region;

    public Clans(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public ApiResponse<ClanInfo> getClanInfo(String clanId) {
        var request = api.newRequest()
                .path(String.format(CLANS_ENDPOINT_FORMAT, region, clanId))
                .build();

        return new ApiResponse<>(api.send(request), ClanInfo.class);
    }
}
