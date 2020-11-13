package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatchController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public MatchController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }


  // http://localhost:8080/matches/PTeemo
  @RequestMapping("matches/{summonerName}")
  public MatchResponse getMatchesBySummoner(@PathVariable String summonerName) {
    return summonerMatchService.getMatchesBySummonerName(summonerName);
  }
}
