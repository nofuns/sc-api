package ru.nofun.stalcraftapi.api;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public abstract class Api {
    protected final HttpClient httpClient;

    protected final Version version;
    protected final int rateLimit = 200;
    protected final long timeout = 20;

    public Api() {
        this.version = Version.PRODUCTION;
        this.httpClient = HttpClient.newHttpClient();
    }

    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder();
    }

    public HttpResponse<String> send(HttpRequest request) {
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}