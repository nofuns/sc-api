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

    public int status() {
        return response.statusCode();
    }

    public String body() {
        return response.body();
    }

    public T asSchemas() {
        return JsonParser.parse(response.body(), tClass);
    }
}
