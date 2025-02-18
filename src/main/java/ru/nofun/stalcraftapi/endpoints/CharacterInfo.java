package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.schemas.FullCharacterInfo;


@AllArgsConstructor
public class CharacterInfo extends ApiMethod<FullCharacterInfo> {
    private static final TypeReference<FullCharacterInfo> jsonFormat = new TypeReference<>() {};
    private static final String CHARACTERS_ENDPOINT_FORMAT = "/character/by-name/%s/profile";

    private final String characterName;

    @Override
    public String getMethod() {
        return String.format(CHARACTERS_ENDPOINT_FORMAT, characterName);
    }

    @Override
    public TypeReference<FullCharacterInfo> getJsonFormat() {
        return jsonFormat;
    }
}
