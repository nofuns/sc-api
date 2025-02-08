package ru.nofun.stalcraftapi.client;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.api.TokenApi;
import ru.nofun.stalcraftapi.endpoints.Auction;
import ru.nofun.stalcraftapi.endpoints.Clans;
import ru.nofun.stalcraftapi.endpoints.Emission;
import ru.nofun.stalcraftapi.endpoints.Characters;
import ru.nofun.stalcraftapi.endpoints.Region;

public class Client {
    private final Api api;

    private final Auction auctionApi;
    private final Clans clansApi;
    private final Emission emissionApi;
    private final Characters charactersApi;

    public Client(String token, Region region) {
        this.api = new TokenApi(token);

        this.auctionApi = new Auction(this.api, region);
        this.clansApi = new Clans(this.api, region);
        this.emissionApi = new Emission(this.api, region);
        this.charactersApi = new Characters(this.api, region);
    }

    public Auction auction() {
        return auctionApi;
    }

    public Emission emission() {
        return emissionApi;
    }

    public Characters characters() {
        return charactersApi;
    }

    public Clans clans() {
        return clansApi;
    }
}
