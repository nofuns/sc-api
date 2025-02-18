package ru.nofun.stalcraftapi.api;

import lombok.NoArgsConstructor;
import ru.nofun.stalcraftapi.response.ApiResponse;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;


@NoArgsConstructor
public class ApiRequestSender {
    private final HttpClient httpClient =  HttpClient.newHttpClient();

    public <T> ApiResponse<T> send(ApiRequest<T> apiRequest) {
        try {
            return new ApiResponse<>(
                    httpClient.send(apiRequest.getRequest(), HttpResponse.BodyHandlers.ofString()));
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
