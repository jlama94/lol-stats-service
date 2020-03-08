package com.lol.leagueoflegends.services;

import com.lol.leagueoflegends.Configuration;
import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
import com.lol.leagueoflegends.models.RiotMatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerMatchService {

  private MatchClient matchClient;
  private SummonerClient summonerClient;

  private static final String RIOT_TOKEN = Configuration.getInstance().getRiotApiKey();

  @Autowired
  public SummonerMatchService(MatchClient matchClient, SummonerClient summonerClient) {
    this.matchClient = matchClient;
    this.summonerClient = summonerClient;
  }



  public Summoner getAccountId(String userName) {
    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(userName, RIOT_TOKEN);
    return summoner;
  }



  /**
   *
   * @param summonerName
   * @return
   */
  public RiotMatchResponse getMatchesBySummonerName(String summonerName) {
    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);
    RiotMatchResponse matchResponse = matchClient.getMatchesForAccountId(summoner.getAccountId(), RIOT_TOKEN);
    return matchResponse;
  }
}
