package ru.nofun.stalcraftapi.utils;

public enum Region {
    RU("ru"),
    EU("eu"),
    NA("na"),
    SEA("sea");

    public final String region;

    Region(String region) {
        this.region = region;
    }

    public String toString() {
        return region;
    }
}