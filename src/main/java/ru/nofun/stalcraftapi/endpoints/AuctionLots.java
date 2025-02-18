package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.type.TypeReference;
import ru.nofun.stalcraftapi.schemas.LotListing;


public class AuctionLots extends ApiMethod <LotListing> {
    private static final TypeReference<LotListing> jsonFormat = new TypeReference<>() {};
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

    @Override
    public String getMethod() {
        return String.format(LOT_LISTING_PATH_FORMAT, itemId)
                + String.format(PARAMS_FORMAT, limit, offset, order, sort, additional ? "true" : "false");
    }

    @Override
    public TypeReference<LotListing> getJsonFormat() {
        return jsonFormat;
    }
}
