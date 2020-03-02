package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.services.SummonerMatchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class MatchControllerTest {


  @Mock SummonerMatchService summonerMatchService;

  private MatchController matchController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    matchController = new MatchController(summonerMatchService);
  }

  @Test
  void getMatches() {
  }
}
