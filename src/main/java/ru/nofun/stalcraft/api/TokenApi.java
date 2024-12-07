package ru.nofun.stalcraft.api;

import java.util.HashMap;
import java.util.Map;


public class TokenApi extends Api {
    private final String token;

    public TokenApi(String token) {
        super();
        this.token = token;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Content-Type", "application/json");

        return headers;
    }

}
