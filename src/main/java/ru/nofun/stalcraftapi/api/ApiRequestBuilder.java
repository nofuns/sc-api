package ru.nofun.stalcraftapi.api;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ApiRequestBuilder {
    private int timeout = 10;

    private final String baseUri;
    private String path;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> params = new HashMap<>();

    public ApiRequestBuilder(String baseUri) {
        this.baseUri = baseUri;
        this.path = "";
    }

    public ApiRequestBuilder header(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public ApiRequestBuilder path(String path) {
        this.path = path;
        return this;
    }

    public ApiRequestBuilder param(String key, String value) {
        params.put(key, value);
        return this;
    }

    public HttpRequest build() {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(this.buildUrl()))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(this.timeout));
        headers.forEach(requestBuilder::setHeader);

        return requestBuilder.build();
    }

    private String buildUrl() {
        String finalUrl = baseUri + path;

        if (params != null && !params.isEmpty()) {
            StringJoiner joiner = new StringJoiner("&");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                joiner.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
            }
            finalUrl += "?" + joiner;
        }

        return finalUrl;
    }
}
