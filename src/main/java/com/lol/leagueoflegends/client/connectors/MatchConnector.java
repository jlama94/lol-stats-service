package com.lol.leagueoflegends.client.connectors;

import com.lol.leagueoflegends.models.MatchResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;


public interface MatchConnector {

  // startDate=2021-02-06&endDate=2021-02-13
  @Headers("X-Riot-Token: {riotToken}")
  @RequestLine("GET /lol/match/v4/matchlists/by-account/{accountId}?beginTime={beginTime}&endTime={endTime}")
  MatchResponse getMatchesForAccountId(@Param("accountId") String accountId,
                                       @Param("beginTime") long beginTime,
                                       @Param("endTime") long endTime,
                                       @Param("riotToken") String riotToken);
}
