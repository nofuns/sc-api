package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.type.TypeReference;


public abstract class ApiMethod <T> {
    public abstract String getMethod();
    public abstract TypeReference<T> getJsonFormat();
}
