package ru.nofun.stalcraftapi.endpoints;

public enum Region {
    RU("ru"),
    EU("eu"),
    NA("na"),
    SEA("sea");

    private final String region;

    Region(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}