//package com.lol.leagueoflegends.services;
//
//import com.lol.leagueoflegends.client.MatchClient;
//import com.lol.leagueoflegends.client.SummonerClient;
//import com.lol.leagueoflegends.models.Match;
//import com.lol.leagueoflegends.models.MatchResponse;
//import com.lol.leagueoflegends.models.Summoner;
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SummonerMatchServiceTest {
//
//  @Mock MatchClient matchClient;
//  @Mock SummonerClient summonerClient;
//  @Mock SummonerMatchService summonerMatchService;
//
//  @BeforeEach
//  void setUp() {
//    MockitoAnnotations.initMocks(this);
//    summonerMatchService = new SummonerMatchService(matchClient, summonerClient);
//  }
//
//  @Test
//  void getSummonerByNameOK() {
//    // given
//    String summonerName = "pteemo";
//    String RIOT_TOKEN = "RGAPI-5cae5179-68b8-415e-87d9-c12e13b9d08b";
//    String account_ID = "12345";
//
//
//    Summoner dummySummoner = new Summoner();
//    dummySummoner.setName(summonerName);
//    dummySummoner.setAccountId(account_ID);
//
//
//    // when called should return a summoner object
//    Mockito.when(summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN))
//      .thenReturn(dummySummoner);
//
//
//    // should not be null
//    Assert.assertNotNull(dummySummoner);
//  }
//
//  // TODO: getMatchesBySummonerNameOk(){}
//
//
//  @Test
//  void getMatchesBySummonerNameOk() {
//
//    // given
//    String summonerName = "pteemo";
//    String RIOT_TOKEN = "RHABCDEFGT123";
//
//    Summoner dummySummoner = new Summoner();
//
//
//    MatchResponse matchResponse = new MatchResponse();
//    Match xMatch = new Match();
//    xMatch.setChampion(new Long(22));
//    xMatch.setPlatformId("NA");
//    xMatch.setSeason(new Long(10));
//    xMatch.setLane("BOTTOM");
//    xMatch.setRole("ROLE");
//    xMatch.setTimestamp(new Long(1234556));
//
//    List<Match> matchList = new ArrayList<>();
//    matchList.add(xMatch);
//
//    matchResponse.setMatches(matchList);
//
//
//    // when
//    Mockito.when(summonerClient.getAccountIdUsingSummonerName(summonerName, RIOT_TOKEN))
//      .thenReturn(dummySummoner);
//
//
//    Mockito.when(matchClient.getMatchesForAccountId(dummySummoner.getAccountId(), RIOT_TOKEN))
//      .thenReturn(matchResponse);
//
//
//    Assert.assertNotNull(matchResponse);
//
//  }
//}
