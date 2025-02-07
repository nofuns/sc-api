package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.CharacterProfileData;

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

    public CharacterProfileData getCharacterProfile(String characterName) throws JsonProcessingException {
        return CharacterProfileData.fromJson(getCharacterProfileRaw(characterName).body());
    }
}
