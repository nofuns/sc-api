package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.endpoints.ApiMethod;


@AllArgsConstructor
public class SecretApi extends Api {
    private final String clientId;
    private final String clientSecret;

    @Override
    public <T> ApiRequestBuilder<T> newRequest(ApiMethod<T> method) {
        return new ApiRequestBuilder<>(method)
                .header("Client-Id", clientId)
                .header("Client-Secret", clientSecret)
                .header("Content-Type", "application/json")
                .version(version);
    }
}
