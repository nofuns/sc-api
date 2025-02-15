package ru.nofun.stalcraftapi.endpoints;

import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.schemas.CharacterProfileData;


@AllArgsConstructor
public class CharacterInfo extends ApiMethod {
    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String characterName;

    @Override
    public String getPath() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, characterName);
    }
}
