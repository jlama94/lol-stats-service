package com.lol.leagueoflegends.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@JsonIgnoreProperties(ignoreUnknown = true) // not needed
@Getter
@Setter
@NoArgsConstructor
public class Summoner {
  private String name;
  private String accountId;
}
