package com.lol.leagueoflegends.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FilteredMatchResponse {
  private String username;
  private List<MatchData> matchData;
}
