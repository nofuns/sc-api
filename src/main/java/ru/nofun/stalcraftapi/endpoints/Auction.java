package ru.nofun.stalcraftapi.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.LotListing;
import ru.nofun.stalcraftapi.schemas.PricesListing;

import java.net.http.HttpResponse;
import java.util.HashMap;


public class Auction {
    private final int DEFAULT_LIMIT = 20;
    private final int DEFAULT_OFFSET = 0;

    private final Api api;
    private final Region region;

    public Auction(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public HttpResponse<String> getItemPriceHistoryRaw(String itemId) {
        return this.getItemPriceHistoryRaw(
                itemId,
                DEFAULT_LIMIT,
                DEFAULT_OFFSET,
                false);
    }

    public HttpResponse<String> getItemPriceHistoryRaw(String itemId, int limit, int offset, boolean additional) {
        String path = String.format("/%s/auction/%s/history", region, itemId);
        return api.requestGet(path, getParams(limit, offset, additional));
    }

    public PricesListing getItemPriceHistory(String itemId) throws JsonProcessingException {
        return this.getItemPriceHistory(
                itemId,
                DEFAULT_LIMIT,
                DEFAULT_OFFSET,
                false);
    }

    public PricesListing getItemPriceHistory(
            String itemId, int limit, int offset, boolean additional) throws JsonProcessingException {

        var responseRaw = getItemPriceHistoryRaw(itemId, limit, offset, additional);
        return PricesListing.fromJson(responseRaw.body());
    }

    public LotListing getActiveItemLots(String itemId) throws JsonProcessingException {
        return this.getActiveItemLots(
                itemId,
                DEFAULT_LIMIT,
                DEFAULT_OFFSET,
                Sort.CURRENT_PRICE,
                Order.ASC,
                false);
    }

    public LotListing getActiveItemLots(
            String itemId, int limit, int offset, Sort sort, Order order, boolean additional) throws JsonProcessingException {

        String path = String.format("/%s/auction/%s/lots", region, itemId);
        return LotListing.fromJson(api.requestGet(path, getParams(limit, offset, sort, order, additional)).body());
    }

    private HashMap<String, String> getParams(
            int limit, int offset, boolean additional) throws IllegalArgumentException {

        HashMap<String, String> params = new HashMap<>();

        if (limit < 0 || limit > 200) throw new IllegalArgumentException("limit must be between 0 and 200");

        params.put("limit" , String.valueOf(limit));
        params.put("offset", String.valueOf(offset));
        params.put("additional", additional ? "true" : "false");
        return params;
    }

    private HashMap<String, String> getParams(
            int limit, int offset, Sort sort, Order order, boolean additional) throws IllegalArgumentException {

        var params = getParams(limit, offset, additional);
        params.put("sort", sort.toString());
        params.put("order", order.toString());

        return params;
    }
}
