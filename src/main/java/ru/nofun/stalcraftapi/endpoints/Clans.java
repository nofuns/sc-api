package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.ClanInfo;

import java.net.http.HttpResponse;


public class Clans {
    private final Api api;
    private final Region region;

    public Clans(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public HttpResponse<String> getClanInfoRaw(String clanId) {
        return api.requestGet(String.format("/%s/clan/%s/info", region, clanId));
    }

    public ClanInfo getClanInfo(String clanId) throws JsonProcessingException {
        return ClanInfo.fromJson(getClanInfoRaw(clanId).body());
    }

}
