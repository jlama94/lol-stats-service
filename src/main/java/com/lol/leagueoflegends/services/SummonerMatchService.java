package com.lol.leagueoflegends.services;

import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
import com.lol.leagueoflegends.configuration.Configuration;

import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Used by MatchController & SummonerController.
 *
 *
 */
@Service
public class SummonerMatchService {

  private MatchClient matchClient;
  private SummonerClient summonerClient;

  private static final String RIOT_TOKEN = Configuration.getInstance().getRiotApiKey();

  @Autowired
  public SummonerMatchService(MatchClient matchClient,
                              SummonerClient summonerClient) {
    this.matchClient = matchClient;
    this.summonerClient = summonerClient;
  }

  public Summoner getSummonerByName(String summonerName) {
    return summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);
  }



  public MatchResponse getMatchesBySummonerName(String summonerName) {

    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);

    MatchResponse matchResponse = matchClient.getMatchesForAccountId(summoner.getAccountId(), RIOT_TOKEN);

    return matchResponse;
  }
}
