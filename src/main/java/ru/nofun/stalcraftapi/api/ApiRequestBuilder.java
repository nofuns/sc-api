package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.endpoints.ApiMethod;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;


public class ApiRequestBuilder {
    private static final String URL_FORMAT = "https://%s.stalcraft.net/%s%s";
    private static final int DEFAULT_TIMEOUT = 10;

    HttpRequest.Builder requestBuilder;

    private Version version;
    private Region region;
    private ApiMethod method;

    ApiRequestBuilder() {
        requestBuilder = HttpRequest.newBuilder();
    }

    public ApiRequestBuilder header(String key, String value) {
        requestBuilder.header(key, value);
        return this;
    }

    public ApiRequestBuilder version(Version version) {
        this.version = version;
        return this;
    }

    public ApiRequestBuilder region(Region region) {
        this.region = region;
        return this;
    }

    public ApiRequestBuilder method(ApiMethod method) {
        this.method = method;
        return this;
    }

    public ApiRequest build() {
        var httpRequest = requestBuilder
                .uri(URI.create(String.format(URL_FORMAT, version.getVersion(), region.getRegion(), method.getPath())))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .build();

        return new ApiRequest(httpRequest);

    }
}
