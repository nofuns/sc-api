package ru.nofun.stalcraftapi.endpoints;

import lombok.Getter;

@Getter
public enum Sort {
    TIME_CREATED("time_created"),
    TIME_LEFT("time_left"),
    CURRENT_PRICE("current_price"),
    BUYOUT_PRICE("buyout_price");

    public final String sort;

    private Sort(String sort) {
        this.sort = sort;
    }
}