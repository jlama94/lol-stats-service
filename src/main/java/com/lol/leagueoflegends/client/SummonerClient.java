package com.lol.leagueoflegends.client;

import com.lol.leagueoflegends.client.connectors.SummonerConnector;
import com.lol.leagueoflegends.models.Summoner;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.stereotype.Component;

// Hits the Riot API
@Component
public class SummonerClient {

  public Summoner getAccountIdUsingSummonerName(String summonerName, String RIOT_TOKEN) {

    SummonerConnector summonerConnector = Feign.builder()
      .decoder(new JacksonDecoder())
      .target(SummonerConnector.class, "https://na1.api.riotgames.com");

    Summoner summoner = summonerConnector.getAccountId(summonerName, RIOT_TOKEN);

    return summoner;
  }
}
