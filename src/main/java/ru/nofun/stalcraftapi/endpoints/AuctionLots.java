package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.schemas.LotListing;


public class AuctionLots extends ApiMethod <LotListing> {
    private static final Class<LotListing> jsonFormat = LotListing.class;
    private static final String LOT_LISTING_PATH_FORMAT = "/auction/%s/lots";
    private static final String PARAMS_FORMAT = "?limit=%d&offset=%d&order=%s&sort=%s&additional=%s";
    public static final int MAX_LIMIT = 200;

    private final String itemId;
    private int limit = MAX_LIMIT;
    private int offset = 0;
    private Order order = Order.ASC;
    private Sort sort = Sort.BUYOUT_PRICE;
    private boolean additional = false;

    public AuctionLots(String itemId){
        this.itemId = itemId;
    }

    public AuctionLots limit(int limit){
        if (limit < 0 || limit > MAX_LIMIT)
            throw new IllegalArgumentException("limit must be between 0 and " + MAX_LIMIT);

        this.limit = limit;
        return this;
    }

    public AuctionLots offset(int offset){
        this.offset = offset;
        return this;
    }

    public AuctionLots order(Order order){
        this.order = order;
        return this;
    }

    public AuctionLots sort(Sort sort){
        this.sort = sort;
        return this;
    }

    public AuctionLots additional(boolean additional){
        this.additional = additional;
        return this;
    }

    @Override
    public String getMethod() {
        return String.format(LOT_LISTING_PATH_FORMAT, itemId)
                + String.format(PARAMS_FORMAT, limit, offset, order, sort, additional ? "true" : "false");
    }

    @Override
    public Class<LotListing> getJsonFormat() {
        return jsonFormat;
    }
}
