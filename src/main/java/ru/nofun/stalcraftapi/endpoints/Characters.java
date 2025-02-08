package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.CharacterProfileData;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class Characters {
    private final Api api;
    private final Region region;

    public Characters(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public HttpResponse<String> getCharacterProfileRaw(String characterName) {
        var request = api.newRequest()
                .path(String.format("/%s/character/by-name/%s/profile", region, characterName))
                .build();

        return api.send(request);
    }

    public CharacterProfileData getCharacterProfile(String characterName) {
        var response = getCharacterProfileRaw(characterName);
        return JsonParser.parse(response.body(), CharacterProfileData.class);
    }
}
