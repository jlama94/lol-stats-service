package com.lol.leagueoflegends.client;

import com.lol.leagueoflegends.client.connectors.MatchConnector;
import com.lol.leagueoflegends.models.RiotMatchResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class MatchClient {

  public RiotMatchResponse getMatchesForAccountId(String accountId, String RIOT_TOKEN){

    MatchConnector matchConnector = Feign.builder()
      .decoder(new JacksonDecoder())
      .target(MatchConnector.class, "https://na1.api.riotgames.com");

    long beginDateTimeInEpochSeconds =
      LocalDateTime.now().minusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0).toEpochSecond(ZoneOffset.UTC);

    RiotMatchResponse matchResponse = matchConnector
      .getMatchesForAccountId(accountId, beginDateTimeInEpochSeconds, RIOT_TOKEN);

    return matchResponse;
  }
}
