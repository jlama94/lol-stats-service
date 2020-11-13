package com.lol.leagueoflegends.services;


import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.models.Summoner;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SummonerMatchServiceTest {

  @Mock MatchClient matchClient;
  @Mock SummonerClient summonerClient;
  @Mock SummonerMatchService summonerMatchService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);

    summonerMatchService = new SummonerMatchService(matchClient, summonerClient);
  }

  @Test
  void getMatchesBySummonerNameOk(){
    // given
    String summonerName = "summonerName";
    String riot_token = "RGAPI-5cae5179-68b8-415e-87d9-c12e13b9d08b";
    String accountId = "accountId";

    Summoner dummySummoner = new Summoner();
    dummySummoner.setAccountId(accountId);
    MatchResponse dummyResponse = new MatchResponse();


    Mockito.when(summonerClient.getAccountIdUsingSummonerName(summonerName, riot_token)).thenReturn(dummySummoner);
    Mockito.when(matchClient.getMatchesForAccountId(accountId, riot_token)).thenReturn(dummyResponse);

    // when
    MatchResponse actualResponse = summonerMatchService.getMatchesBySummonerName(summonerName);


    Assert.assertEquals(dummyResponse, actualResponse);
  }

}
