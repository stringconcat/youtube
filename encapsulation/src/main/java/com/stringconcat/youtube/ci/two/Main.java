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
                AllianceCriteria.exact(new Alliance("SkyTeam"))
        );

        // DATABASE
        String findSkyTeamFlightsQuery;
        if (findSkyTeamFlights.belongsTo instanceof AllianceCriteria.Exact) {
            findSkyTeamFlightsQuery = ((AllianceCriteria.Exact) findSkyTeamFlights.belongsTo).alliance.id;
        } else if (findSkyTeamFlights.belongsTo instanceof AllianceCriteria.None) {
            findSkyTeamFlightsQuery = " ";
        } else {
            throw new IllegalArgumentException("ooops");
        }

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQuery);

    }

    public static void none() {
        var findAllFlights = new FlightSearch(
                ZonedDateTime.now(),
                AllianceCriteria.none()
        );

        String findAllFlightsQuery;
        if (findAllFlights.belongsTo instanceof AllianceCriteria.Exact) {
            findAllFlightsQuery = ((AllianceCriteria.Exact) findAllFlights.belongsTo).alliance.id;
        } else if (findAllFlights.belongsTo instanceof AllianceCriteria.None) {
            findAllFlightsQuery = " ";
        } else {
            throw new IllegalArgumentException("ooops");
        }

        System.out.println("find All Flights Query: " + findAllFlightsQuery);
    }
}
