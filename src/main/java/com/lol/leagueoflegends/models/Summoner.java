package com.lol.leagueoflegends.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@JsonIgnoreProperties(ignoreUnknown = true) // not needed
@NoArgsConstructor
@Getter
@Setter
public class Summoner {
  private String name;
  private String accountId;
}
