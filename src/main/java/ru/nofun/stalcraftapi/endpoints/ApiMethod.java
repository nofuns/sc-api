package ru.nofun.stalcraftapi.endpoints;


public abstract class ApiMethod <T> {
    public abstract String getMethod();
    public abstract Class<T> getJsonFormat();
}
