package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.services.SummonerMatchService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    RiotMatch firstExpectedMatch = new RiotMatch();

    List<RiotMatch> expectedMatches = Arrays.asList(firstExpectedMatch);

    RiotMatchResponse expectedMatchResponse = new RiotMatchResponse();
    expectedMatchResponse.setMatches(expectedMatches);

    Mockito.when(summonerMatchService.getMatchesBySummonerName(summonerName)).thenReturn(expectedMatchResponse);

    //When
    List<RiotMatch> actual = summonerController.getMatches(summonerName);

    //Then
    Assert.assertEquals(expectedMatches, actual);
  }

   */
}
