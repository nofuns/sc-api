package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.net.http.HttpRequest;


@AllArgsConstructor
@Getter
public class ApiRequest <T> {
    private final HttpRequest request;
    private final Class<T> jsonFormat;
}
