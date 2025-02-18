package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.endpoints.ApiMethod;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;


public class ApiRequestBuilder<T> {
    private static final String URL_FORMAT = "https://%s.stalcraft.net/%s%s";
    private static final int DEFAULT_TIMEOUT = 10;

    private final HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();

    private Version version;
    private Region region;
    private final ApiMethod<T> method;

    public ApiRequestBuilder(ApiMethod<T> method) {
        this.method = method;
    }

    public ApiRequestBuilder<T> header(String key, String value) {
        requestBuilder.header(key, value);
        return this;
    }

    public ApiRequestBuilder<T> version(Version version) {
        this.version = version;
        return this;
    }

    public ApiRequestBuilder<T> region(Region region) {
        this.region = region;
        return this;
    }

    public ApiRequest<T> build() {
        var httpRequest = requestBuilder
                .uri(URI.create(String.format(URL_FORMAT, version.getVersion(), region.getRegion(), method.getMethod())))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .build();

        return new ApiRequest<>(httpRequest);
    }

}
