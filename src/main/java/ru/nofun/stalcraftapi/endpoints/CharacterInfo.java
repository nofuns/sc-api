package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.CharacterProfileData;


public class CharacterInfo implements ApiMethod {
    public static Class<CharacterProfileData> JSON_FORMAT = CharacterProfileData.class;

    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String characterName;

    public CharacterInfo(String characterName) {
        this.characterName = characterName;
    }

    public String get() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, characterName);
    }
}
