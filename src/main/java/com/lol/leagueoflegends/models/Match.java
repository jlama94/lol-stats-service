package com.lol.leagueoflegends.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Match {
  private String platformId;
  private Long champion;
  private Long season;
  private String role;
  private String lane;
  private Long timestamp;
}
