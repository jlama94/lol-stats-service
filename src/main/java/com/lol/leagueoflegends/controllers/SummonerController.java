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
  public SummonerController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }

  /**
   *
   * @param userName
   * @return Summoner name & accountID
   */
  @RequestMapping("/summoners/{userName}")
  public Summoner getAccountId(@PathVariable String userName) {
    return summonerMatchService.getAccountId(userName);
  }
}
