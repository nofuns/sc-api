package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.api.ApiResponse;
import ru.nofun.stalcraftapi.schemas.CharacterProfileData;


public class Characters {
    private static final String CHARACTERS_ENDPOINT_FORMAT = "/%s/character/by-name/%s/profile";

    private final Api api;
    private final Region region;

    public Characters(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public ApiResponse<CharacterProfileData> getCharacterProfile(String characterName) {
        var request = api.newRequest()
                .path(String.format(CHARACTERS_ENDPOINT_FORMAT, region, characterName))
                .build();

        return new ApiResponse<>(api.send(request), CharacterProfileData.class);
    }
}
