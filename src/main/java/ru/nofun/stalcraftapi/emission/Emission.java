package ru.nofun.stalcraftapi.emission;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.EmissionResponse;
import ru.nofun.stalcraftapi.utils.Region;


public class Emission {
    private final Api api;
    private final Region region;

    public Emission(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public EmissionResponse status() {
        String path = String.format("/%s/emission", region);

        try {
            return EmissionResponse.fromJson(api.requestGet(path).body());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
