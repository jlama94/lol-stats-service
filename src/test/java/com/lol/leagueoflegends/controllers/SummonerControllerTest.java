package com.lol.leagueoflegends.controllers;

<<<<<<< HEAD
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

=======
import com.lol.leagueoflegends.models.Match;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

>>>>>>> refactoring
class SummonerControllerTest {

  @Mock
  private SummonerMatchService summonerMatchService;

  private SummonerController summonerController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    summonerController = new SummonerController(summonerMatchService);
  }

  /*
  @Test
  void getMatchesReturnsSuccessfully() {
    //Given
    String summonerName = "pTeemo";

<<<<<<< HEAD
    RiotMatch firstExpectedMatch = new RiotMatch();

    List<RiotMatch> expectedMatches = Arrays.asList(firstExpectedMatch);

    RiotMatchResponse expectedMatchResponse = new RiotMatchResponse();
=======
    Match firstExpectedMatch = new Match();

    List<Match> expectedMatches = Arrays.asList(firstExpectedMatch);

    MatchResponse expectedMatchResponse = new MatchResponse();
>>>>>>> refactoring
    expectedMatchResponse.setMatches(expectedMatches);

    Mockito.when(summonerMatchService.getMatchesBySummonerName(summonerName)).thenReturn(expectedMatchResponse);

    //When
<<<<<<< HEAD
    List<RiotMatch> actual = summonerController.getMatches(summonerName);
=======
    List<Match> actual = summonerController.getMatches(summonerName);
>>>>>>> refactoring

    //Then
    Assert.assertEquals(expectedMatches, actual);
  }

   */
<<<<<<< HEAD
=======

  @Test
  void getSummonerNameSuccessfully() {
    // Given some summonerName
    String summonerName = "PTeemo";

    // An object of type Summoner.
    Summoner expectedSomeSummoner = new Summoner();

    // When called return some object of type Summoner.
    Mockito.when(summonerMatchService.getSummonerByName(summonerName)).thenReturn(expectedSomeSummoner);


    // When actually called.
    Summoner actual = summonerMatchService.getSummonerByName(summonerName);


    // then check -> what type should return & what was returned.
    Assert.assertEquals(expectedSomeSummoner, actual);

  }
>>>>>>> refactoring
}
