package ru.nofun.stalcraftapi.clans;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.ClanInfo;
import ru.nofun.stalcraftapi.utils.Region;


public class Clans {
    private final Api api;
    private final Region region;

    public Clans(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public ClanInfo getClanInfo(String clanId) {
        try {
            return ClanInfo.fromJson(api.requestGet(String.format("/%s/clan/%s/info", region, clanId)).body());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
