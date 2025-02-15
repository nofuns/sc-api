package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.PricesListing;

public class AuctionHistory extends ApiMethod   {
    public static final int MAX_LIMIT = 200;

    private static final String LOT_LISTING_PATH_FORMAT = "/auction/%s/history";
    private static final String PARAMS_FORMAT = "?limit=%d&offset=%d&additional=%s";

    private final String itemId;
    private int limit = MAX_LIMIT;
    private int offset = 0;
    private boolean additional = false;

    public AuctionHistory(String itemId){
        this.itemId = itemId;
    }

    public AuctionHistory(String itemId, int limit, int offset, boolean additional) {
        this.itemId = itemId;
        this.limit = limit;
        this.offset = offset;
        this.additional = additional;
    }

    @Override
    public String getPath() {
        return String.format(LOT_LISTING_PATH_FORMAT, itemId)
                + String.format(PARAMS_FORMAT, limit, offset, additional ? "true" : "false");
    }
}
