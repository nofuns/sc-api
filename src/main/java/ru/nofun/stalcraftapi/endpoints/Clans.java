package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.ClanInfo;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class Clans {
    private final Api api;
    private final Region region;

    public Clans(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public HttpResponse<String> getClanInfoRaw(String clanId) {
        var request = api.newRequest()
                .path(String.format("/%s/clan/%s/info", region, clanId))
                .build();

        return api.send(request);
    }

    public ClanInfo getClanInfo(String clanId){
        var response = getClanInfoRaw(clanId);
        return JsonParser.parse(response.body(), ClanInfo.class);
    }

}
