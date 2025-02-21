package ru.nofun.stalcraftapi.api;

import lombok.NoArgsConstructor;
import ru.nofun.stalcraftapi.endpoints.ApiMethod;


@NoArgsConstructor
public abstract class Api {
    private static final int RATE_LIMIT = 200;

    protected Version version = Version.PRODUCTION;

    public static int getRateLimit() {
        return RATE_LIMIT;
    }

    public <T> ApiRequestBuilder<T> newRequest(ApiMethod<T> method) {
        return new ApiRequestBuilder<>(method)
                .version(version);
    }
}