package com.lol.leagueoflegends.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class RiotMatch {
  private String platformId;
  private Long champion;
  private Long timestamp;
  private Long season;
  private String role;
  private String lane;
}
