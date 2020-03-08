package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.RiotMatch;
import com.lol.leagueoflegends.models.MatchData;
import com.lol.leagueoflegends.models.RiotMatchResponse;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.List;


@RestController
public class MatchController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public MatchController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }

  /**
   * @param summonerName
   * @return a List of from Riot API.
   */
  @RequestMapping("/matches/{summonerName}")
  public MatchResponse getMatches(@PathVariable String summonerName) {

    RiotMatchResponse matchResponse = summonerMatchService.getMatchesBySummonerName(summonerName);

    MatchResponse filteredMatchResponse;

    List<MatchData> matches = new ArrayList<>();
    MatchData match;

    for (RiotMatch responseMatch : matchResponse.getMatches()) {
      match = new MatchData(responseMatch.getTimestamp(), responseMatch.getChampion(), responseMatch.getRole());
      matches.add(match);
    }
    filteredMatchResponse = new MatchResponse(summonerName, matches);

    return filteredMatchResponse;
  }
}
