package ru.nofun.stalcraftapi.api;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.http.HttpRequest;


@AllArgsConstructor
@Getter
public class ApiRequest <T> {
    private final TypeReference<T> jsonFormat = new TypeReference<>(){};
    private final HttpRequest request;
}
