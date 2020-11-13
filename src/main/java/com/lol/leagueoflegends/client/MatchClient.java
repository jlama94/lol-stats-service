package com.lol.leagueoflegends.client;

import com.lol.leagueoflegends.client.connectors.MatchConnector;
import com.lol.leagueoflegends.models.RiotMatchResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.stereotype.Component;


/**
 * MatchClient: uses the MatchConnector to hit Riot's API
 * Location: src/main/java/com/lol/leagueoflegends/client/connectors/MatchConnector.java
 */
@Component
public class MatchClient {

  /**
   *
   * @param accountId
   * @param startDate in epochSeconds
   * @param RIOT_TOKEN
   * @return
   */
  public RiotMatchResponse getMatchesForAccountId(String accountId,
                                                  long startDate,
                                                  String RIOT_TOKEN) {

    MatchConnector matchConnector = Feign.builder()
      .decoder(new JacksonDecoder())
      .target(MatchConnector.class, "https://na1.api.riotgames.com");

    /*
    long beginDateTimeInEpochSeconds =
   LocalDateTime.now().minusDays(7).withHour(0).withMinute(0).withSecond(0).withNano(0).toEpochSecond(ZoneOffset.UTC);
  */

    RiotMatchResponse riotMatchResponse = matchConnector
      .getMatchesForAccountId(accountId, startDate, RIOT_TOKEN);


    return riotMatchResponse;
  }
}
