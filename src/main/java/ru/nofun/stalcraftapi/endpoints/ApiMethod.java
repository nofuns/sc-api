package ru.nofun.stalcraftapi.endpoints;


public abstract class ApiMethod <T> {
    public abstract String getApiMethod();
    public abstract HttpMethod getHttpMethod();
    public abstract Class<T> getSchemasFormat();
}
