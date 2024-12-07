package ru.nofun.stalcraftapi.utils;

public enum Order {
    ASC("asc"),
    DESC("desc");

    public final String order;

    Order(String order) {
        this.order = order;
    }

    public String toString() {
        return order;
    }
}