package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.FriendListing;

public class FriendList extends ApiGetMethod<FriendListing> {
    private static final Class<FriendListing> jsonFormat = FriendListing.class;
    private static final String FRIENDS_LIST_ENDPOINT_FORMAT = "/friends/%s";

    private final String characterName;

    public FriendList(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String getApiMethod() {
        return String.format(FRIENDS_LIST_ENDPOINT_FORMAT, characterName);
    }

    @Override
    public Class<FriendListing> getJsonFormat() {
        return jsonFormat;
    }
}
