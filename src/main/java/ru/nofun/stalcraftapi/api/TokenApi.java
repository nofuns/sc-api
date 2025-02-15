package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class TokenApi extends ApiImpl {
    private final String token;

    @Override
    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .version(version);
    }
}
