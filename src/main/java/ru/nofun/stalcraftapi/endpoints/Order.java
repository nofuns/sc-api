package ru.nofun.stalcraftapi.endpoints;

import lombok.Getter;

@Getter
public enum Order {
    ASC("asc"),
    DESC("desc");

    public final String order;

    private Order(String order) {
        this.order = order;
    }
}