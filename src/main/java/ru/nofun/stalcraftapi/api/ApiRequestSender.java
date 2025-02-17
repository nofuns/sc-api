package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.response.ApiResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class ApiRequestSender {
    private final HttpClient httpClient;

    public ApiRequestSender() {
        httpClient = HttpClient.newHttpClient();
    }

    public <T> ApiResponse<T> send(ApiRequest<T> apiRequest) {
        try {
            var response =  httpClient.send(apiRequest.getRequest(), HttpResponse.BodyHandlers.ofString());
            return new ApiResponse<T>(response);

        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
