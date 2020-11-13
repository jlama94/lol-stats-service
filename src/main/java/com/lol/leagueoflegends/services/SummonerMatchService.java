package com.lol.leagueoflegends.services;

import com.lol.leagueoflegends.configuration.Configuration;
import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
import com.lol.leagueoflegends.client.connectors.SummonerConnector;
import com.lol.leagueoflegends.models.Match;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Uses MatchClient & SummonerClient
 */
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



    /*
      STEPS:
      1) get the summoner name (the accountId really).
      2) get the matches with the returned summoner name using the accountId.
   */
  public MatchResponse getMatchesBySummonerName(String summonerName) {

    // used here
    // testing
    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);


  /**
   *
   * @param summonerName
   * @return
   */
  public RiotMatchResponse getMatchesBySummonerName(String summonerName, long startDate) {
    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);
    return matchClient.getMatchesForAccountId(summoner.getAccountId(), startDate, RIOT_TOKEN);
  }
}
