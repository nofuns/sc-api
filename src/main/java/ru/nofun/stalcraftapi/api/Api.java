package ru.nofun.stalcraftapi.api;

import ru.nofun.stalcraftapi.endpoints.*;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;


public abstract class Api {
    protected static final int RATE_LIMIT = 200;

    protected static final int DEFAULT_TIMEOUT = 10;
    protected static final String URL_FORMAT = "https://%s.stalcraft.net/%s%s";

    protected final Version version;
    protected int timeout = DEFAULT_TIMEOUT;

    public Api() {
        this.version = Version.PRODUCTION;
    }

    public Api(Version version) {
        this.version = version;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public static int getRateLimit() {
        return RATE_LIMIT;
    }

    public HttpRequest newRequest(Region region, ApiMethod method) {
        return HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_FORMAT, version.getVersion(), region.getRegion(), method.get())))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .timeout(Duration.ofSeconds(this.timeout))
                .build();
    }
}