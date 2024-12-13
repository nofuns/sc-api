package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.EmissionResponse;

import java.net.http.HttpResponse;


public class Emission {
    private final Api api;
    private final Region region;

    public Emission(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public HttpResponse<String> statusRaw() {
        return api.requestGet(String.format("/%s/emission", region));
    }

    public EmissionResponse status() throws JsonProcessingException {
        return EmissionResponse.fromJson(statusRaw().body());
    }
}
