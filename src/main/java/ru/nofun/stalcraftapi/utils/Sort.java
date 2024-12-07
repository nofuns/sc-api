package ru.nofun.stalcraftapi.utils;

public enum Sort {
    TIME_CREATED("time_created"),
    TIME_LEFT("time_left"),
    CURRENT_PRICE("current_price"),
    BUYOUT_PRICE("buyout_price");

    public final String sort;

    Sort(String sort) {
        this.sort = sort;
    }

    public String toString() {
        return sort;
    }
}