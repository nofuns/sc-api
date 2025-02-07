package ru.nofun.stalcraftapi.api;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;


public class TokenApi extends Api {
    private final String token;

    public TokenApi(String token) {
        super();
        this.token = token;
    }

    @Override
    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder(baseUrl)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
    }

}
