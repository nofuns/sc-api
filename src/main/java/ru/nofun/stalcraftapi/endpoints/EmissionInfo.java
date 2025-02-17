package ru.nofun.stalcraftapi.endpoints;

import lombok.NoArgsConstructor;
import ru.nofun.stalcraftapi.schemas.EmissionResponse;


@NoArgsConstructor
public class EmissionInfo extends ApiMethod<EmissionResponse> {
    private static final Class<EmissionResponse> jsonFormat = EmissionResponse.class;

    private static final String EMISSION_ENDPOINT_FORMAT = "/emission";

    @Override
    public String getPath() {
        return EMISSION_ENDPOINT_FORMAT;
    }

    @Override
    public Class<EmissionResponse> getJsonFormat() {
        return jsonFormat;
    }
}
