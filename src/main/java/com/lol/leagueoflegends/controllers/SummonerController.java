package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.client.connectors.SummonerConnector;
import com.lol.leagueoflegends.models.Match;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import com.lol.leagueoflegends.services.SummonerMatchService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummonerController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public SummonerController(SummonerMatchService service) {
    this.summonerMatchService = service;
  }


  // when feign is called builds the URL as:   //https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/pTeemo
  @RequestMapping("/summoners/{summonerName}")
  public Summoner getSummonerByName(@PathVariable String summonerName){
    SummonerConnector summonerConnector = Feign.builder()
      .decoder(new JacksonDecoder())
      .target(SummonerConnector.class, "https://na1.api.riotgames.com"); //base URL appended by Feign.

    String riotToken = "RGAPI-96098270-3e1b-4d85-9952-08dd769c5cc0";

    Summoner summoner = summonerConnector.getAccountId(summonerName, riotToken);

    return summoner;
  }

  @RequestMapping("/matches/{summonerName}")
  public List<Match> getMatches(@PathVariable String summonerName) {

    MatchResponse matchResponse = summonerMatchService.getMatchesBySummonerName(summonerName);

    return matchResponse.getMatches();
  }
}