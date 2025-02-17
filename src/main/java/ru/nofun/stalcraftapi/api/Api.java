package ru.nofun.stalcraftapi.api;

import lombok.Getter;
import lombok.Setter;
import ru.nofun.stalcraftapi.endpoints.*;
import ru.nofun.stalcraftapi.response.*;
import ru.nofun.stalcraftapi.schemas.*;

public class Api {
    private final ApiImpl apiImpl;
    private final ApiRequestSender requestSender;

    @Getter
    @Setter
    private Region region;

    public Api(ApiImpl apiImpl, Region region) {
        this.apiImpl = apiImpl;
        this.region = region;
        this.requestSender = new ApiRequestSender();
    }

    public ApiResponse<PricesListing> lotPriceHistory(String itemId) {
        return sendRequest(new AuctionHistory(itemId));
    }

    public ApiResponse<PricesListing> getLotPriceHistory(
            String itemId, int limit, int offset, boolean additional) {

        return sendRequest(new AuctionHistory(itemId, limit, offset, additional));
    }

    public ApiResponse<LotListing> getLotList(
            String itemId, int limit, int offset, Order order, Sort sort, boolean additional) {

        return sendRequest(new AuctionLots(itemId, limit, offset, order, sort, additional));
    }

    public ApiResponse<LotListing> getLotList(String itemId) {
        return sendRequest(new AuctionLots(itemId));
    }

    public ApiResponse<EmissionResponse> getEmissionInfo() {
        return sendRequest(new EmissionInfo());
    }

    public ApiResponse<ClanInfo> getClanInformation(String clanId) {
        return sendRequest(new ClanInformation(clanId));
    }

    public ApiResponse<FullCharacterInfo> getCharacterInfo(String characterName) {
        return sendRequest(new CharacterInfo(characterName));
    }

    private <T> ApiResponse<T> sendRequest(ApiMethod<T> method) {
        return requestSender.send(
                apiImpl.newRequest(method)
                .region(region)
                .build());
    }

    private void Test() {
        ApiImpl apiImpl = new TokenApi("");
        var request = apiImpl.newRequest(new AuctionHistory("")).region(region).build();
        ApiRequestSender requestSender = new ApiRequestSender();
        var response = requestSender.send(request);

    }
}
