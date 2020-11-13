package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.models.Summoner;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SummonerController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public SummonerController(SummonerMatchService service) {
    this.summonerMatchService = service;
  }

  //http://localhost:8080/summoners/PTeemo
  @RequestMapping("/summoners/{summonerName}")
  public Summoner getSummonerByName(@PathVariable String summonerName){
    return summonerMatchService.getSummonerByName(summonerName);
  }
}
