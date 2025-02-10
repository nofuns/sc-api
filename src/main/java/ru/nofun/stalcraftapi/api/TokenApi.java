package ru.nofun.stalcraftapi.api;


public class TokenApi extends Api {
    private final String token;

    public TokenApi(String token) {
        super();
        this.token = token;
    }

    @Override
    public ApiRequestBuilder newRequest() {
        return new ApiRequestBuilder()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .version(version);
    }

}
