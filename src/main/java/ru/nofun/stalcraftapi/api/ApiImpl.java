package ru.nofun.stalcraftapi.api;

import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.nofun.stalcraftapi.endpoints.ApiMethod;


@NoArgsConstructor
public abstract class ApiImpl {
    private static final int RATE_LIMIT = 200;
    private static final int DEFAULT_TIMEOUT = 10;

    protected Version version = Version.PRODUCTION;

    @Setter
    protected int timeout = DEFAULT_TIMEOUT;

    public static int getRateLimit() {
        return RATE_LIMIT;
    }

    public <T> ApiRequestBuilder<T> newRequest(ApiMethod<T> method) {
        return new ApiRequestBuilder<>(method)
                .version(version);
    }
}