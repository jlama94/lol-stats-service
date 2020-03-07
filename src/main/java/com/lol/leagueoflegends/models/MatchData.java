package com.lol.leagueoflegends.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class MatchData {
  private String date;
  private Long champion;
  private String role;
}
