package ru.nofun.stalcraftapi.api;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.http.HttpRequest;

@AllArgsConstructor
@Getter
public class ApiRequest <T> {
    private HttpRequest request;
    private TypeReference<T> jsonFormat;

    public ApiRequest(HttpRequest request) {
        this.request = request;
        this.jsonFormat = new TypeReference<T>(){};
    }
}
