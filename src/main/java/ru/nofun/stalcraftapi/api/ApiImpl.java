package ru.nofun.stalcraftapi.api;

import lombok.NoArgsConstructor;
import lombok.Setter;


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

    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder()
                .version(version);
    }
}