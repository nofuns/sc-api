package ru.nofun.stalcraftapi.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;


public abstract class Api {
    String baseUrl;
    int rateLimit;
    long timeout;

    public Api() {
        this.baseUrl = "http://eapi.stalcraft.net";
        this.rateLimit = 200;
        this.timeout = 5;
    }

    public Map<String, String> getHeaders() {
        return new HashMap<>();
    }

    public HttpResponse<String> requestGet(String url) {
        return requestGet(url, new HashMap<>());
    }

    public HttpResponse<String> requestGet(String url, Map<String, String> params) {

        if (params != null && !params.isEmpty()) {
            StringJoiner joiner = new StringJoiner("&");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                joiner.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
            }
            url += "?" + joiner;
        }

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + url))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .timeout(Duration.ofSeconds(this.timeout));

            getHeaders().forEach(requestBuilder::setHeader);

            return client.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}