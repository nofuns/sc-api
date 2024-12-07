package ru.nofun.stalcraftapi.client;

import ru.nofun.stalcraftapi.api.Api;
import ru.nofun.stalcraftapi.auction.Auction;
import ru.nofun.stalcraftapi.clans.Clans;
import ru.nofun.stalcraftapi.emission.Emission;
import ru.nofun.stalcraftapi.character.Characters;
import ru.nofun.stalcraftapi.utils.Region;


public class Client {
    String baseUrl;
    Api api;
    Region region;

    public Client(Api api, Region region) {
        this.api = api;
        this.region = region;
    }

    /**
     * Factory method for auction requests
     * @return new object for working with auction requests
     */
    public Auction auction() {
        return new Auction(this.api, this.region);
    }

    /**
     * Factory method for emission requests
     * @return new object for working with emission requests
     */
    public Emission emission() {
        return new Emission(this.api, this.region);
    }

    /**
     * Factory method for character requests
     * @return new object for working with character requests
     */
    public Characters characters() {
        return new Characters(this.api, this.region);
    }

    /**
     * Factory method for clans requests
     * @return new object for working with clans requests
     */
    public Clans clans() {
        return new Clans(this.api, this.region);
    }
}
