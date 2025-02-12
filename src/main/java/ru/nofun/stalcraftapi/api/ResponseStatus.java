package ru.nofun.stalcraftapi.api;

public enum ResponseStatus {
    UNKNOWN(0),
    OK(200),
    INVALID_PARAMETER(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    RATE_LIMIT_EXCEEDED(429);

    private final int statusCode;

    private ResponseStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
