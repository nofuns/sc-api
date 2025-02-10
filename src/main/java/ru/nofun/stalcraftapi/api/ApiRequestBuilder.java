package ru.nofun.stalcraftapi.api;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ApiRequestBuilder {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final String ROOT_PATH = "";
    private static final String URL_FORMAT = "https://%s.stalcraft.net%s%s";

    private Version version;
    private String path;
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> params = new HashMap<>();
    private int timeout = DEFAULT_TIMEOUT;

    public ApiRequestBuilder() {
        this.path = ROOT_PATH;
    }

    public ApiRequestBuilder version(Version version) {
        this.version = version;
        return this;
    }

    public ApiRequestBuilder timeout(int seconds) {
        this.timeout = seconds;
        return this;
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
        return String.format(URL_FORMAT, version.getVersion(), path, paramsToString());
    }

    private String paramsToString() {
        if (params.isEmpty())
            return "";

        StringJoiner joiner = new StringJoiner("&");
        params.forEach((k, v) -> joiner.add(String.format("%s=%s", k, v)));

        return "?" + joiner;

    }
}
