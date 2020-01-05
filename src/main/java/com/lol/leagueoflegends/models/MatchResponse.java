package com.lol.leagueoflegends.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MatchResponse {
  private List<Match> matches;
}
