package ru.nofun.stalcraftapi.endpoints;

public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private final String method;

    HttpMethod(String method) {
        this.method = method;
    }


    @Override
    public String toString() {
        return method;
    }
}