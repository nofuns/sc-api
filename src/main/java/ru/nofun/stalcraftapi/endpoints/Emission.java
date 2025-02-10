package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.api.ApiResponse;
import ru.nofun.stalcraftapi.schemas.EmissionResponse;


public class Emission {
    private static final String EMISSION_ENDPOINT_FORMAT = "/%s/emission";

    private final Api api;
    private final Region region;

    public Emission(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public ApiResponse<EmissionResponse> status() {
        var request = api.newRequest()
                .path(String.format(EMISSION_ENDPOINT_FORMAT, region))
                .build();

        return new ApiResponse<>(api.send(request), EmissionResponse.class);
    }
}
