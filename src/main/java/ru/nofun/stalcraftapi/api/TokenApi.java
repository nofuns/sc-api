package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.endpoints.ApiMethod;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;


public class TokenApi extends Api {
    private final String token;

    public TokenApi(String token) {
        super();
        this.token = token;
    }

    public TokenApi(Version version, String token) {
        super(version);
        this.token = token;
    }

    @Override
    public HttpRequest newRequest(Region region, ApiMethod method) {
        return HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .uri(URI.create(String.format(URL_FORMAT, version.getVersion(), region.getRegion(), method.get())))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(this.timeout))
                .build();
    }
}
