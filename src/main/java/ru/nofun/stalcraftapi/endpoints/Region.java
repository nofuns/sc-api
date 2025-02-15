package ru.nofun.stalcraftapi.endpoints;

import lombok.Getter;

@Getter
public enum Region {
    RU("ru"),
    EU("eu"),
    NA("na"),
    SEA("sea");

    private final String region;

    private Region(String region) {
        this.region = region;
    }
}