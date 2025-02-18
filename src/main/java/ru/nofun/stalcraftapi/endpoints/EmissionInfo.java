package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.NoArgsConstructor;
import ru.nofun.stalcraftapi.schemas.EmissionResponse;


@NoArgsConstructor
public class EmissionInfo extends ApiMethod<EmissionResponse> {
    private static final TypeReference<EmissionResponse> jsonFormat = new TypeReference<>() {};
    private static final String EMISSION_ENDPOINT_FORMAT = "/emission";

    @Override
    public String getMethod() {
        return EMISSION_ENDPOINT_FORMAT;
    }

    @Override
    public TypeReference<EmissionResponse> getJsonFormat() {
        return jsonFormat;
    }
}
