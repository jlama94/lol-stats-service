package com.lol.leagueoflegends.services;

import com.lol.leagueoflegends.Configuration;
import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
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

//  private static final String RIOT_TOKEN = "RGAPI-a6f72780-4cb2-4555-8ba7-487650da0239";

  private static final String RIOT_TOKEN = Configuration.getRiotApiKey();

  /**
   *
   * @param summonerName
   * @return a List<Match> of 100 matches starting 7 days ago from local time today.
   */
  public MatchResponse getMatchesBySummonerName(String summonerName) {

    // We use the SummonerClient to get the summoner name & account ID.
    Summoner summoner = summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN);

    // We use the accountId that we got to get the list of matches using the MatchClient.
    MatchResponse matchResponse = matchClient.getMatchesForAccountId(summoner.getAccountId(), RIOT_TOKEN);

    return matchResponse;
  }
}
