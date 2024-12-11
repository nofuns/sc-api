package ru.nofun.stalcraftapi.endpoints;

public enum Order {
    ASC("asc"),
    DESC("desc");

    public final String order;

    Order(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}