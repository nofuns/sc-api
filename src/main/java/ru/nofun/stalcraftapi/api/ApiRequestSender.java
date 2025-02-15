package ru.nofun.stalcraftapi.api;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class ApiRequestSender {
    private final HttpClient httpClient;

    public ApiRequestSender() {
        httpClient = HttpClient.newHttpClient();
    }

    public ApiResponse send(ApiRequest apiRequest) {
        try {
            var response = httpClient.send(apiRequest.getRequest(), HttpResponse.BodyHandlers.ofString());
            return new ApiResponse(response);
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
