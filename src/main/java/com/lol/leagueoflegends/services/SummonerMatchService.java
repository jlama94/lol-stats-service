package com.lol.leagueoflegends.services;

import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
import com.lol.leagueoflegends.client.connectors.SummonerConnector;
import com.lol.leagueoflegends.models.Match;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerMatchService {

  private MatchClient matchClient;
  private SummonerClient summonerClient;

  @Autowired
  public SummonerMatchService(MatchClient matchClient,
                              SummonerClient summonerClient) {
    this.matchClient = matchClient;
    this.summonerClient = summonerClient;
  }

  private static final String RIOT_TOKEN = "RGAPI-5cae5179-68b8-415e-87d9-c12e13b9d08b";


    /*
      STEPS:
      1) get the summoner name (the accountId really).
      2) get the matches with the returned summoner name using the accountId.
   */
  public MatchResponse getMatchesBySummonerName(String summonerName) {

    // used here
    // testing
    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);

    MatchResponse matchResponse = matchClient.getMatchesForAccountId(summoner.getAccountId(), RIOT_TOKEN);

    return matchResponse;
  }
}
