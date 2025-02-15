package ru.nofun.stalcraftapi.api;

import lombok.Getter;


@Getter
public enum Version {
    DEMO("dapi"),
    PRODUCTION("eapi");

    private final String version;

    private Version(String version) {
        this.version = version;
    }
}
