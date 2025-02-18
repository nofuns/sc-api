package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.endpoints.ApiMethod;


@AllArgsConstructor
public class TokenApi extends Api {
    private final String token;

    @Override
    public <T> ApiRequestBuilder<T> newRequest(ApiMethod<T> method) {
        return new ApiRequestBuilder<>(method)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .version(version);
    }
}
