package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
public class MatchController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public MatchController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }

  //Format = 2020-02-08 yyyy-MM-dd

  // http://localhost:8080/matches/PTeemo
  @RequestMapping("matches/{summonerName}")
  public MatchResponse getMatchesBySummoner(@PathVariable String summonerName,
                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
    return summonerMatchService.getMatchesBySummonerName(summonerName, startDate, endDate);
  }
}
