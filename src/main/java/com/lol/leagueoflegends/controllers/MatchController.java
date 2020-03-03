package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.models.Match;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public MatchController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }


  @RequestMapping("/matches/{summonerName}")
  public List<Match> getMatches(@PathVariable String summonerName) {

    MatchResponse matchResponse = summonerMatchService.getMatchesBySummonerName(summonerName);

    return matchResponse.getMatches();
  }
}
