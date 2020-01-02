package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public MatchController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }

  /*
  @RequestMapping("/matches/{accountId}/{startDate}")
  MatchResponse getLast7Matches(@PathVariable String accountId) {
    MatchConnector matchConnector = Feign.builder().decoder(new JacksonDecoder())
      .target(MatchConnector.class, "https://na1.api.riotgames.com");

    String riotToken = "RGAPI-96098270-3e1b-4d85-9952-08dd769c5cc0";

    MatchResponse matches = matchConnector.getMatchesForAccountId(accountId, "1577232000", riotToken);
    return matches;
  }

  @RequestMapping("/matches/summoner/{summonerName}")
  MatchResponse getMatchesForSummoner(@PathVariable String summonerName) {
    MatchResponse matchResponse = summonerMatchService.getMatchesBySummonerName(summonerName);
    return null;
  }
  */
}
