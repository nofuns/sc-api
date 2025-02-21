package ru.nofun.stalcraftapi.schemas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ClanListResponse(
    int totalClans,
    ArrayList<ClanInfo> data
) {

}
