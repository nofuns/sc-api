package ru.nofun.stalcraftapi.api;


public enum Version {
    DEMO("dapi"),
    PRODUCTION("eapi");

    private final String version;

    private Version(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
