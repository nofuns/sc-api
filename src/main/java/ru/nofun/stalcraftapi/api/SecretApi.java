package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
public class SecretApi extends ApiImpl {
    private final String clientId;
    private final String clientSecret;

    @Override
    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder()
                .header("Client-Id", clientId)
                .header("Client-Secret", clientSecret)
                .header("Content-Type", "application/json")
                .version(version);
    }
}
