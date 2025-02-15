package ru.nofun.stalcraftapi.endpoints;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EmissionInfo extends ApiMethod {
    private static final String EMISSION_ENDPOINT_FORMAT = "/emission";

    @Override
    public String getPath() {
        return EMISSION_ENDPOINT_FORMAT;
    }
}
