package com.lol.leagueoflegends.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class MatchData {
  private Long date;
  private Long champion;
  private String role;
}
