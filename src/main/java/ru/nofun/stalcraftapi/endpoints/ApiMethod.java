package ru.nofun.stalcraftapi.endpoints;


public abstract class ApiMethod <T> {
    public abstract String getPath();
    public abstract Class<T> getJsonFormat();
}
