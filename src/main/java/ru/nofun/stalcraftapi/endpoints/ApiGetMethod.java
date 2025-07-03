package ru.nofun.stalcraftapi.endpoints;

public abstract class ApiGetMethod<T> extends ApiMethod<T> {
    private static final HttpMethod httpMethod = HttpMethod.GET;

    @Override
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
