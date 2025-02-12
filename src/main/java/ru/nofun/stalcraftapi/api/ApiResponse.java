package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class ApiResponse <T> {
    private final HttpResponse<String> response;
    private final Class<T> tClass;

    public ApiResponse(HttpResponse<String> response, Class<T> tClass) {
        this.response = response;
        this.tClass = tClass;
    }

    public ResponseStatus status() {
        return switch (response.statusCode()) {
            case 200 -> ResponseStatus.OK;
            case 400 -> ResponseStatus.INVALID_PARAMETER;
            case 401 -> ResponseStatus.UNAUTHORIZED;
            case 404 -> ResponseStatus.NOT_FOUND;
            case 429 -> ResponseStatus.RATE_LIMIT_EXCEEDED;
            default -> ResponseStatus.UNKNOWN;
        };
    }

    public String body() {
        return response.body();
    }

    public T asSchemas() {
        return JsonParser.parse(response.body(), tClass);
    }
}
