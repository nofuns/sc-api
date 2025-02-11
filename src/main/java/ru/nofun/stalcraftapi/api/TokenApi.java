package ru.nofun.stalcraftapi.api;


import ru.nofun.stalcraftapi.endpoints.ApiMethod;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.http.HttpRequest;

public class TokenApi extends Api {
    private final String token;

    public TokenApi(String token) {
        super();
        this.token = token;
    }

    public TokenApi(Version version, String token) {
        super(version);
        this.token = token;
    }

    @Override
    public HttpRequest newRequest(Region region, ApiMethod method) {
        return new ApiRequestBuilder()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .version(version)
                .region(region)
                .path(method.get())
                .build();
    }
}
