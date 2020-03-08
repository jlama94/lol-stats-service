package com.lol.leagueoflegends.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class MatchResponse {
  private String username;
  private List<MatchData> matchData;
}
