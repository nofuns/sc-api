package ru.nofun.stalcraftapi.endpoints;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.LotListing;
import ru.nofun.stalcraftapi.schemas.PricesListing;
import ru.nofun.stalcraftapi.utils.JsonParser;

import java.net.http.HttpResponse;


public class Auction {
    public static final int DEFAULT_LIMIT = 20;
    public static final int DEFAULT_OFFSET = 0;
    public static final int MAX_LIMIT = 200;

    private final Api api;
    private final Region region;

    public Auction(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public PricesListing getItemPriceHistory(String itemId) {
        return this.getItemPriceHistory(
                itemId,
                DEFAULT_LIMIT,
                DEFAULT_OFFSET,
                false);
    }

    public PricesListing getItemPriceHistory(
            String itemId, int limit, int offset, boolean additional) {

        var responseRaw = getItemPriceHistoryRaw(itemId, limit, offset, additional);
        return JsonParser.parse(responseRaw.body(), PricesListing.class);
    }

    public HttpResponse<String> getItemPriceHistoryRaw(
            String itemId, int limit, int offset, boolean additional) {

        var apiRequest = api.newRequest()
                .path(String.format("/%s/auction/%s/history", region, itemId))
                .param("limit", String.valueOf(limit))
                .param("offset", String.valueOf(offset))
                .param("additional", additional ? "true" : "false")
                .build();

        return api.send(apiRequest);
    }

    public LotListing getActiveItemLots(String itemId) {
        return this.getActiveItemLots(
                itemId,
                DEFAULT_LIMIT,
                DEFAULT_OFFSET,
                Sort.CURRENT_PRICE,
                Order.ASC,
                false);
    }

    public LotListing getActiveItemLots(
            String itemId, int limit, int offset, Sort sort, Order order, boolean additional) {

        var response = getActiveItemLotsRaw(itemId, limit, offset, sort, order, additional);
        return JsonParser.parse(response.body(), LotListing.class);
    }

    public HttpResponse<String> getActiveItemLotsRaw(
            String itemId, int limit, int offset, Sort sort, Order order, boolean additional) {

        if (limit < 0 || limit > MAX_LIMIT)
            throw new IllegalArgumentException(String.format("limit must be between 0 and %d", MAX_LIMIT));

        var apiRequest = api.newRequest()
                .path(String.format("/%s/auction/%s/lots", region, itemId))
                .param("limit", String.valueOf(limit))
                .param("offset", String.valueOf(offset))
                .param("sort", sort.toString())
                .param("order", order.toString())
                .param("additional", additional ? "true" : "false")
                .build();

        return api.send(apiRequest);
    }
}