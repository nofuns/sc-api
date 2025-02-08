package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.EmissionResponse;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class Emission {
    private final Api api;
    private final Region region;

    public Emission(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public HttpResponse<String> statusRaw() {
        var request = api.newRequest()
                .path(String.format("/%s/emission", region))
                .build();

        return api.send(request);
    }

    public EmissionResponse status() {
        var response = statusRaw();
        return JsonParser.parse(response.body(), EmissionResponse.class);
    }
}
