package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.PricesListing;


public class AuctionHistory extends ApiMethod<PricesListing> {
    private static final Class<PricesListing> jsonFormat = PricesListing.class;
    private static final String LOT_LISTING_PATH_FORMAT = "/auction/%s/history";
    private static final String PARAMS_FORMAT = "?limit=%d&offset=%d&additional=%s";
    public static final int MAX_LIMIT = 200;

    private final String itemId;
    private int limit = MAX_LIMIT;
    private int offset = 0;
    private boolean additional = false;

    public AuctionHistory(String itemId) {
        this.itemId = itemId;
    }

    public AuctionHistory limit(int limit) {
        if (limit < 0 || limit > MAX_LIMIT)
            throw new IllegalArgumentException("limit must be between 0 and " + MAX_LIMIT);

        this.limit = limit;
        return this;
    }

    public AuctionHistory offset(int offset) {
        this.offset = offset;
        return this;
    }

    public AuctionHistory additional(boolean additional) {
        this.additional = additional;
        return this;
    }

    @Override
    public String getMethod() {
        return String.format(LOT_LISTING_PATH_FORMAT, itemId)
                + String.format(PARAMS_FORMAT, limit, offset, additional ? "true" : "false");
    }

    @Override
    public Class<PricesListing> getJsonFormat() {
        return jsonFormat;
    }
}
