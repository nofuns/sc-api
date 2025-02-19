package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.FriendListing;

public class FriendList extends ApiMethod<FriendListing> {
    private static final Class<FriendListing> jsonFormat = FriendListing.class;
    private static final String REGIONS_ENDPOINT_FORMAT = "/friends/%s";

    private final String characterName;

    public FriendList(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String getMethod() {
        return String.format(REGIONS_ENDPOINT_FORMAT, characterName);
    }

    @Override
    public Class<FriendListing> getJsonFormat() {
        return jsonFormat;
    }
}
