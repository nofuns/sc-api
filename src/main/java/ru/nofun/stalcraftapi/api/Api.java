package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.endpoints.ApiMethod;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.http.HttpRequest;


public abstract class Api {
    protected final Version version;
    protected final int rateLimit = 200;
    protected final long timeout = 20;

    public Api() {
        this.version = Version.PRODUCTION;
    }

    public Api(Version version) {
        this.version = version;
    }

    public HttpRequest newRequest(Region region, ApiMethod method) {
        return new ApiRequestBuilder()
                .version(version)
                .region(region)
                .path(method.get())
                .build();
    }
}