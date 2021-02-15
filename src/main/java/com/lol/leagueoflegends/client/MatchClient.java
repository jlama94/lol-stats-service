package com.lol.leagueoflegends.client;

import com.lol.leagueoflegends.client.connectors.MatchConnector;
import com.lol.leagueoflegends.models.MatchResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;

// Hits the Riot API
@Component
public class MatchClient {

  public MatchResponse getMatchesForAccountId(String accountId, LocalDate startDate, LocalDate endDate, String RIOT_TOKEN) {

    MatchConnector matchConnector = Feign.builder()
      .decoder(new JacksonDecoder())
      .target(MatchConnector.class, "https://na1.api.riotgames.com");


    long startDateTime = startDate.atStartOfDay()
      .atZone(ZoneOffset.UTC).toInstant().toEpochMilli();

    long endDateTime = endDate.atStartOfDay()
      .atZone(ZoneOffset.UTC).toInstant().toEpochMilli();


    MatchResponse matchResponse = matchConnector
      .getMatchesForAccountId(accountId, startDateTime, endDateTime, RIOT_TOKEN);

    return matchResponse;
  }
}
