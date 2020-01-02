package com.lol.leagueoflegends.client.connectors;

import com.lol.leagueoflegends.models.Summoner;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface SummonerConnector {
  /*
      Headers: metadata about a request.
   */
  // "method type, API/endpoint"
  @Headers("X-Riot-Token: {riotToken}")
  @RequestLine("GET /lol/summoner/v4/summoners/by-name/{summonerName}")
  Summoner getAccountId(@Param("summonerName") String summonerName,
                        @Param("riotToken") String riotToken);
}
