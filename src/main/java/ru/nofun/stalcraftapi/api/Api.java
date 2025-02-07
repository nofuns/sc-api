package ru.nofun.stalcraftapi.api;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public abstract class Api {
    public static final String DEMO_API = "https://dapi.stalcraft.net";
    public static final String PRODUCTION_API  = "https://eapi.stalcraft.net";

    protected final String baseUrl;
    protected final int rateLimit = 200;
    protected final long timeout = 20;

    public Api() {
        this.baseUrl = PRODUCTION_API;
    }

    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder(baseUrl);
    }

    public HttpResponse<String> send(HttpRequest request) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}