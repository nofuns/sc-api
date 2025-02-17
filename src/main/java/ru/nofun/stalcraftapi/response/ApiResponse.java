package ru.nofun.stalcraftapi.response;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class ApiResponse <T> {
    private final HttpResponse<String> response;
    private final TypeReference<T> jsonFormat;

    public ApiResponse(HttpResponse<String> response) {
        this.response = response;
        jsonFormat = new TypeReference<T>() {};
    }

    public ResponseStatus status() {
        return ResponseStatus.fromValue(response.statusCode());
    }

    public String body() {
        return response.body();
    }

    public T asSchemas() {
        return JsonParser.parse(response.body(), jsonFormat);
    }
}
