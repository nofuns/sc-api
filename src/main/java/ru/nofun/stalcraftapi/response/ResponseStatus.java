package ru.nofun.stalcraftapi.response;

import lombok.Getter;

@Getter
public enum ResponseStatus {
    OK(200),
    INVALID_PARAMETER(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    RATE_LIMIT_EXCEEDED(429);

    private final int statusCode;

    private ResponseStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    static ResponseStatus fromValue(int statusCode) throws IllegalArgumentException {
        for (ResponseStatus status : ResponseStatus.values()) {
            if (status.statusCode == statusCode) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid status code: " + statusCode);
    }
}
