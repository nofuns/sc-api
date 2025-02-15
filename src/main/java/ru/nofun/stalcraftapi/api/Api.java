package ru.nofun.stalcraftapi.api;

import lombok.Getter;
import lombok.Setter;
import ru.nofun.stalcraftapi.endpoints.*;
import ru.nofun.stalcraftapi.schemas.*;
import ru.nofun.stalcraftapi.utils.JsonParser;


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

    public PricesListing lotPriceHistory(String itemId) {
        return JsonParser.parse(sendRequest(new AuctionHistory(itemId)).body(), PricesListing.class);
    }

    public PricesListing getLotPriceHistory(
            String itemId, int limit, int offset, boolean additional) {

        return JsonParser.parse(sendRequest(new AuctionHistory(itemId, limit, offset, additional)).body(), PricesListing.class);
    }

    public LotListing getLotList(
            String itemId, int limit, int offset, Order order, Sort sort, boolean additional) {

        return JsonParser.parse(
                sendRequest(
                        new AuctionLots(itemId, limit, offset, order, sort, additional)).body(),
                        LotListing.class);
    }

    public LotListing getLotList(String itemId) {
        return JsonParser.parse(
                sendRequest(
                        new AuctionLots(itemId)).body(),
                        LotListing.class);
    }

    public EmissionResponse getEmissionInfo() {
        return JsonParser.parse(
                sendRequest(
                        new EmissionInfo()).body(),
                        EmissionResponse.class);
    }

    public ClanInfo getClanInformation(String clanId) {
        return JsonParser.parse(
                sendRequest(
                        new ClanInformation(clanId)).body(),
                        ClanInfo.class);
    }

    public CharacterInfo getCharacterInfo(String characterName) {
        return JsonParser.parse(
                sendRequest(
                        new CharacterInfo(characterName)).body(),
                        CharacterInfo.class);
    }

    private ApiResponse sendRequest(ApiMethod method) {
        return requestSender.send(apiImpl.newRequest()
                .region(region)
                .method(method)
                .build());
    }
}
