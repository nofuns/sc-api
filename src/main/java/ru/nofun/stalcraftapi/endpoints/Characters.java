package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.CharacterProfileData;


public class Characters {
    private final Api api;
    private final Region region;

    public Characters(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public CharacterProfileData getCharacterProfile(String characterName) {
        String path = String.format("/%s/character/by-name/%s/profile", region, characterName);
        try {
            return CharacterProfileData.fromJson(api.requestGet(path).body());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
