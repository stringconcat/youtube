package com.stringconcat.youtube.ci.one;

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
                new Consortium("SkyTeam")
        );

        // DATABASE
        String findSkyTeamFlightsQuery = findSkyTeamFlights.belongsTo!=null?findSkyTeamFlights.belongsTo.id:" ";

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQuery);
    }

    public static void none() {
        var findAllFlights = new FlightSearch(
                ZonedDateTime.now(),
                null
        );

        String findAllFlightsQuery = findAllFlights.belongsTo!=null?findAllFlights.belongsTo.id:" ";

        System.out.println("find All Flights Query: " + findAllFlightsQuery);
    }
}
