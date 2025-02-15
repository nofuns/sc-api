package ru.nofun.stalcraftapi.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.http.HttpRequest;

@AllArgsConstructor
@Getter
public class ApiRequest {
    private HttpRequest request;
}
