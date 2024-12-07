package ru.nofun.stalcraftapi.auction;

import com.fasterxml.jackson.core.JsonProcessingException;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.schemas.LotListing;
import ru.nofun.stalcraftapi.schemas.PricesListing;
import ru.nofun.stalcraftapi.utils.Order;
import ru.nofun.stalcraftapi.utils.Region;
import ru.nofun.stalcraftapi.utils.Sort;
import java.util.HashMap;
import java.util.Map;

//TODO: Response code
public class Auction {
    private final Api api;
    private final Region region;


    public Auction(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    public PricesListing getItemPriceHistory(String itemId) {
        return this.getItemPriceHistory(itemId, 20, 0, false);
    }

    //TODO: params
    public PricesListing getItemPriceHistory(String itemId, int limit, int offset, boolean additional) {
        Map<String, String> params = new HashMap<>();
        params.put("limit" , String.valueOf(limit));
        params.put("offset", String.valueOf(offset));
        params.put("additional", additional ? "true" : "false");

        String path = String.format("/%s/auction/%s/history", region, itemId);

        try {
            return PricesListing.fromJson(api.requestGet(path, params).body());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public LotListing getActiveItemLots(String itemId) {
        return this.getActiveItemLots(itemId, 20, 0, Sort.CURRENT_PRICE, Order.ASC, false);
    }

    public LotListing getActiveItemLots(String itemId, int limit, int offset, Sort sort, Order order, boolean additional) {
        Map<String, String> params = new HashMap<>();
        params.put("limit", String.valueOf(limit));
        params.put("offset", String.valueOf(offset));
        params.put("sort", sort.toString());
        params.put("order", order.toString());
        params.put("additional", additional ? "true" : "false");

        String path = String.format("/%s/auction/%s/lots", region, itemId);

        try {
            return LotListing.fromJson(api.requestGet(path, params).body());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
