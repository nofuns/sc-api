package ru.nofun.stalcraftapi.response;

import lombok.NonNull;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class ApiResponse <T> {
    @NonNull
    protected final HttpResponse<String> response;
    private final Class<T> jsonFormat;
    private T schemas = null;

    public ApiResponse(@NonNull HttpResponse<String> response, @NonNull Class<T> jsonFormat) {
        this.response = response;
        this.jsonFormat = jsonFormat;
    }

    public ResponseStatus status() {
        return ResponseStatus.fromValue(response.statusCode());
    }

    public String body() {
        return response.body();
    }

    public T schemas() {
        if (schemas == null) {
            schemas = JsonParser.parse(body(), jsonFormat);
        }
        return schemas;
    }

}
