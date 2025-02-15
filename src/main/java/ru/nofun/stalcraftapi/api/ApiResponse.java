package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


@AllArgsConstructor
public class ApiResponse  {
    private final HttpResponse<String> response;

    public ResponseStatus status() {
        return ResponseStatus.fromValue(response.statusCode());
    }

    public String body() {
        return response.body();
    }

    public <T> T asSchemas(Class<T> jsonFormat) {
        return JsonParser.parse(response.body(), jsonFormat);
    }
}
