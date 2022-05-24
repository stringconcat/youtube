package com.stringconcat.youtube.ci.two;

import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        exact();
        none();
    }

    public static void exact() {
        // API
        var findSkyTeamFlights = new FlightSearch(
                ZonedDateTime.now(),
                ConsortiumCriteria.exact(new Consortium("SkyTeam"))
        );

        // DATABASE
        String findSkyTeamFlightsQuery;
        if (findSkyTeamFlights.belongsTo instanceof ConsortiumCriteria.Exact) {
            findSkyTeamFlightsQuery = ((ConsortiumCriteria.Exact) findSkyTeamFlights.belongsTo).consortium.id;
        } else if (findSkyTeamFlights.belongsTo instanceof ConsortiumCriteria.None) {
            findSkyTeamFlightsQuery = " ";
        } else {
            throw new IllegalArgumentException("ooops");
        }

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQuery);

    }

    public static void none() {
        var findAllFlights = new FlightSearch(
                ZonedDateTime.now(),
                ConsortiumCriteria.none()
        );

        String findAllFlightsQuery;
        if (findAllFlights.belongsTo instanceof ConsortiumCriteria.Exact) {
            findAllFlightsQuery = ((ConsortiumCriteria.Exact) findAllFlights.belongsTo).consortium.id;
        } else if (findAllFlights.belongsTo instanceof ConsortiumCriteria.None) {
            findAllFlightsQuery = " ";
        } else {
            throw new IllegalArgumentException("ooops");
        }

        System.out.println("find All Flights Query: " + findAllFlightsQuery);
    }
}
