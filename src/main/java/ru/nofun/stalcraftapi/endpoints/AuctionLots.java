package ru.nofun.stalcraftapi.endpoints;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class AuctionLots extends ApiMethod {
    public static final int MAX_LIMIT = 200;

    private static final String LOT_LISTING_PATH_FORMAT = "/auction/%s/lots";
    private static final String PARAMS_FORMAT = "?limit=%d&offset=%d&order=%s&sort=%s&additional=%s";

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
    public String getPath() {
        return String.format(LOT_LISTING_PATH_FORMAT, itemId)
                + String.format(PARAMS_FORMAT, limit, offset, order, sort, additional ? "true" : "false");
    }
}
