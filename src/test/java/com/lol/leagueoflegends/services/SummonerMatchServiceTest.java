package com.lol.leagueoflegends.services;

import com.lol.leagueoflegends.client.MatchClient;
import com.lol.leagueoflegends.client.SummonerClient;
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
  void getSummonerByNameOK() {
    // given
    String summonerName = "pteemo";
    String RIOT_TOKEN = "RGAPI-5cae5179-68b8-415e-87d9-c12e13b9d08b";
    String account_ID = "12345";


    Summoner dummySummoner = new Summoner();
    dummySummoner.setName(summonerName);
    dummySummoner.setAccountId(account_ID);


    // when called should return a summoner object
    Mockito.when(summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN))
      .thenReturn(dummySummoner);


    // should not be null
    Assert.assertNotNull(dummySummoner);
  }


  /*
  @Test
  void getMatchesBySummonerNameOk(){
//    // given
//    String summonerName = "summonerName";
////    String riot_token = "RGAPI-5cae5179-68b8-415e-87d9-c12e13b9d08b";
//    String riot_token = Configuration.getInstance().getRiotApiKey();
//    String accountId = "accountId";
//
//    Summoner dummySummoner = new Summoner();
//    dummySummoner.setAccountId(accountId);
//    RiotMatchResponse dummyResponse = new RiotMatchResponse();
//
//
//    Mockito.when(summonerClient.getAccountIdUsingSummonerName(summonerName, riot_token)).thenReturn(dummySummoner);
//    Mockito.when(matchClient.getMatchesForAccountId(accountId, riot_token)).thenReturn(dummyResponse);
//
//    // when
//    RiotMatchResponse actualResponse = summonerMatchService.getMatchesBySummonerName(summonerName);
//
//
//    Assert.assertEquals(dummyResponse, actualResponse);

    // given
    String summonerName = "summonerName";
    String RIOT_TOKEN = "RGAPI-5cae5179-68b8-415e-87d9-c12e13b9d08b";
    String account_ID = "12345";

    Summoner dummySummoner = new Summoner();
    dummySummoner.setAccountId(account_ID);

    MatchResponse dummyResponse = new MatchResponse(); // some response expected

    // when
    Mockito.when(summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN)).thenReturn(dummySummoner);
    Mockito.when(matchClient.getMatchesForAccountId(account_ID, RIOT_TOKEN)).thenReturn(dummyResponse);


    // call of the service
    MatchResponse actualResponse = summonerMatchService.getMatchesBySummonerName(summonerName);

    Assert.assertEquals(dummyResponse, actualResponse);

  }

   */
}
