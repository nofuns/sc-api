package ru.nofun.stalcraftapi.api;

import lombok.NoArgsConstructor;
import ru.nofun.stalcraftapi.response.ApiResponse;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;


@NoArgsConstructor
public class ApiRequestSender {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public <T> ApiResponse<T> send(ApiRequest<T> apiRequest) {
        try {
            return new ApiResponse<T>(
                    httpClient.send(apiRequest.getRequest(), HttpResponse.BodyHandlers.ofString()),
                    apiRequest.getJsonFormat());
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
