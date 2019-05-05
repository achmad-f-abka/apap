package com.apap.tu07.controller;

import com.amadeus.Amadeus;
import com.amadeus.Params;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.Location;

public class AmadeusExample {
  public static void main(String[] args) throws ResponseException {
    Amadeus amadeus = Amadeus
            .builder("jdPZPAFmKq2iRyQ2uUWhq8AjpPoCi1wk", "PSQAlPuZLIgW55W9")
            .build();

    Location[] locations = amadeus.referenceData.locations.get(Params
      .with("keyword", "LON")
      .and("subType", Locations.ANY));

    System.out.println(locations);
  }
}