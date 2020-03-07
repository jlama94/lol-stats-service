package com.lol.leagueoflegends.controllers;

import com.lol.leagueoflegends.models.FilteredMatchResponse;
import com.lol.leagueoflegends.models.Match;
import com.lol.leagueoflegends.models.MatchData;
import com.lol.leagueoflegends.models.MatchResponse;
import com.lol.leagueoflegends.services.SummonerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;


@RestController
public class MatchController {

  private SummonerMatchService summonerMatchService;

  @Autowired
  public MatchController(SummonerMatchService summonerMatchService) {
    this.summonerMatchService = summonerMatchService;
  }

  /**
   * @param summonerName
   * @return a List of matches within 7 days.
   */
  @RequestMapping("/matches/{summonerName}")
  public FilteredMatchResponse getMatches(@PathVariable String summonerName){

    MatchResponse matchResponse = summonerMatchService.getMatchesBySummonerName(summonerName);

    FilteredMatchResponse filteredMatchResponse = new FilteredMatchResponse();

    List<MatchData> matches = new ArrayList<>();
    MatchData match = null;

    for (int i = 0; i < matchResponse.getMatches().size(); i++) {
      Match currentMatch = matchResponse.getMatches().get(i);

      // if the timestamp -> Date is within today & 7 days ago, add it to the List<MatchData>.
      if (isTimestampWithinRange(currentMatch.getTimestamp()))
      {
        match = new MatchData();
        // format to a String for the MatchData object field: Date
        String format = ZonedDateTime.ofInstant(Instant.ofEpochMilli(currentMatch.getTimestamp()), ZoneOffset.UTC)
          .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        match.setChampion(currentMatch.getChampion());
        match.setRole(currentMatch.getRole());
        match.setDate(format);

        matches.add(match);
      }
    }


    filteredMatchResponse.setUsername(summonerName);
    filteredMatchResponse.setMatchData(matches);


    return filteredMatchResponse;
  }


  /**
   * Helper method that checks if current timestamp is within range, counting today and seven days ago.
   * @param epochSeconds
   * @return
   */
  private boolean isTimestampWithinRange(long epochSeconds) {

    // current match from the loop from list of matches returned from riot
    Instant instantOfCurrentMatch = Instant.ofEpochMilli(epochSeconds);
    ZonedDateTime currentMatchDateTime = ZonedDateTime.ofInstant(instantOfCurrentMatch, ZoneOffset.UTC);

    ZonedDateTime sevenDaysAgoDateTime = ZonedDateTime.now(ZoneOffset.UTC).minusDays(6)
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0);

    return currentMatchDateTime.isAfter(sevenDaysAgoDateTime);
  }
}
