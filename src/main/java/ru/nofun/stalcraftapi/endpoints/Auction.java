package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.api.ApiResponse;
import ru.nofun.stalcraftapi.schemas.LotListing;
import ru.nofun.stalcraftapi.schemas.PricesListing;


public class Auction {
    public static final int DEFAULT_LIMIT = 20;
    public static final int DEFAULT_OFFSET = 0;
    public static final int MAX_LIMIT = 200;

    private static final String PRICE_HISTORY_PATH_FORMAT = "/%s/auction/%s/history";
    private static final String LOT_LISTING_PATH_FORMAT = "/%s/auction/%s/lots";

    private final Api api;
    private final Region region;

    public Auction(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public ApiResponse<PricesListing> getItemPriceHistory(String itemId) {
        return this.getItemPriceHistory(itemId, DEFAULT_LIMIT, DEFAULT_OFFSET, false);
    }

    public ApiResponse<PricesListing> getItemPriceHistory(String itemId, int limit, int offset, boolean additional) {
        if (limit < 0 || limit > MAX_LIMIT)
            throw new IllegalArgumentException(String.format("limit must be between 0 and %d", MAX_LIMIT));

        var apiRequest = api.newRequest()
                .path(String.format(PRICE_HISTORY_PATH_FORMAT, region, itemId))
                .param("limit", String.valueOf(limit))
                .param("offset", String.valueOf(offset))
                .param("additional", additional ? "true" : "false")
                .build();

        return new ApiResponse<>(api.send(apiRequest), PricesListing.class);
    }


    public ApiResponse<LotListing> getActiveItemLots(String itemId) {
        return getActiveItemLots(itemId, DEFAULT_LIMIT, DEFAULT_OFFSET, Sort.BUYOUT_PRICE, Order.ASC, false);
    }

    public ApiResponse<LotListing> getActiveItemLots(
            String itemId, int limit, int offset, Sort sort, Order order, boolean additional
    ) {

        if (limit < 0 || limit > MAX_LIMIT)
            throw new IllegalArgumentException(String.format("limit must be between 0 and %d", MAX_LIMIT));

        var apiRequest = api.newRequest()
                .path(String.format(LOT_LISTING_PATH_FORMAT, region, itemId))
                .param("limit", String.valueOf(limit))
                .param("offset", String.valueOf(offset))
                .param("sort", sort.getSort())
                .param("order", order.getOrder())
                .param("additional", additional ? "true" : "false")
                .build();

        return new ApiResponse<>(api.send(apiRequest), LotListing.class);
    }
}