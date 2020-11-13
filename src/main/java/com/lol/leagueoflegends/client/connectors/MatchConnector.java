package com.lol.leagueoflegends.client.connectors;

import com.lol.leagueoflegends.models.RiotMatchResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

// https://developer.riotgames.com/apis#match-v4
public interface MatchConnector {

  @Headers("X-Riot-Token: {riotToken}")
  @RequestLine("GET /lol/match/v4/matchlists/by-account/{accountId}?beginTime={beginTime}")
  RiotMatchResponse getMatchesForAccountId(@Param("accountId") String accountId,
                                           @Param("beginTime") long beginTime,
                                           @Param("riotToken") String riotToken);
}
