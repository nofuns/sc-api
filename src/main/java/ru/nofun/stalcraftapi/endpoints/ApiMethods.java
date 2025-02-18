package ru.nofun.stalcraftapi.endpoints;


public class ApiMethods {
    private ApiMethods() {}

    public static AuctionHistory auctionHistory(String itemId) {
        return new AuctionHistory(itemId);
    }

    public static AuctionLots lotList(String itemId) {
        return new AuctionLots(itemId);
    }

    public static CharacterInfo characterInfo(String characterName) {
        return new CharacterInfo(characterName);
    }

    public static ClanInformation clanInfo(String clanId) {
        return new ClanInformation(clanId);
    }

    public static EmissionInfo lotList() {
        return new EmissionInfo();
    }
}
