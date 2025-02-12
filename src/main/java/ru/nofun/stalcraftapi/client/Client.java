package ru.nofun.stalcraftapi.client;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.api.ApiResponse;
import ru.nofun.stalcraftapi.endpoints.*;
import ru.nofun.stalcraftapi.schemas.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private final Api api;
    private final HttpClient httpClient;
    private Region region;

    public Client(Api api, Region region) {
        this.api = api;
        this.region = region;
        this.httpClient = HttpClient.newHttpClient();
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public ApiResponse<PricesListing> lotPriceHistory(String itemId) {
        var response = sendRequest(api.newRequest(region, new AuctionHistory(itemId)));
        return new ApiResponse<>(response, AuctionHistory.JSON_FORMAT);
    }

    public ApiResponse<PricesListing> lotPriceHistory(
            String itemId, int limit, int offset, boolean additional) {

        var response = sendRequest(api.newRequest(region, new AuctionHistory(itemId, limit, offset, additional)));
        return new ApiResponse<>(response, AuctionHistory.JSON_FORMAT);
    }

    public ApiResponse<LotListing> lotList(
            String itemId, int limit, int offset, Order order, Sort sort, boolean additional) {

        var response = sendRequest(
                api.newRequest(
                        region,
                        new AuctionLots(itemId, limit, offset, order, sort, additional)));

        return new ApiResponse<>(response, AuctionLots.JSON_FORMAT);
    }

    public ApiResponse<LotListing> lotList(String itemId) {
        var response = sendRequest(api.newRequest(region, new AuctionLots(itemId)));
        return new ApiResponse<>(response, AuctionLots.JSON_FORMAT);
    }

    public ApiResponse<EmissionResponse> emissionInfo() {
        var response = sendRequest(api.newRequest(region, new EmissionInfo()));
        return new ApiResponse<>(response, EmissionInfo.JSON_FORMAT);
    }

    public ApiResponse<ClanInfo> clanInformation(String clanId) {
        var response = sendRequest(api.newRequest(region, new ClanInformation(clanId)));
        return new ApiResponse<>(response, ClanInformation.JSON_FORMAT);
    }

    public ApiResponse<CharacterProfileData> characterInfo(String characterName) {
        var response = sendRequest(api.newRequest(region, new CharacterInfo(characterName)));
        return new ApiResponse<>(response, CharacterInfo.JSON_FORMAT);
    }

    private HttpResponse<String> sendRequest(HttpRequest request) {
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
