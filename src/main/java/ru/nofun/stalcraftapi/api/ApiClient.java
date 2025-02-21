package ru.nofun.stalcraftapi.api;

import lombok.Getter;
import lombok.Setter;
import ru.nofun.stalcraftapi.endpoints.*;
import ru.nofun.stalcraftapi.response.*;


public class ApiClient {
    private final ApiRequestSender requestSender = new ApiRequestSender();
    private final Api api;

    @Getter
    @Setter
    private Region region = Region.RU;

    public ApiClient() {
        this.api = new DemoApi();
    }

    public ApiClient(String token) {
        this.api = new TokenApi(token);
    }

    public ApiClient(String clientId, String clientSecret) {
        this.api = new SecretApi(clientId, clientSecret);
    }

    public <T> ApiResponse<T> sendRequest(ApiMethod<T> method) {
        return requestSender.send(
                api.newRequest(method)
                .region(region)
                .build());
    }
}
