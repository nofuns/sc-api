package ru.nofun.stalcraftapi.endpoints;


import ru.nofun.stalcraftapi.schemas.EmissionResponse;

public class EmissionInfo implements ApiMethod {
    public static final Class<EmissionResponse> JSON_FORMAT = EmissionResponse.class;

    private static final String EMISSION_ENDPOINT_FORMAT = "/emission";

    public EmissionInfo()
    { }

    public String get() {
        return EMISSION_ENDPOINT_FORMAT;
    }
}
