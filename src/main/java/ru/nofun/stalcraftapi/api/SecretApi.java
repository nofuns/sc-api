package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.endpoints.ApiMethod;
import ru.nofun.stalcraftapi.endpoints.Region;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

public class SecretApi extends Api {
    private final String clientId;
    private final String clientSecret;

    public SecretApi(String clientId, String clientSecret) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public SecretApi(Version version, String clientId, String clientSecret) {
        super(version);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public HttpRequest newRequest(Region region, ApiMethod method) {
        return HttpRequest.newBuilder()
                .header("Client-Id", clientId)
                .header("Client-Secret", clientSecret)
                .header("Content-Type", "application/json")
                .uri(URI.create(String.format(URL_FORMAT, version.getVersion(), region.getRegion(), method.get())))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(this.timeout))
                .build();
    }
}
