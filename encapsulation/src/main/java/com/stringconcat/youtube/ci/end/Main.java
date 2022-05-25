package com.stringconcat.youtube.ci.end;

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
        String findSkyTeamFlightsQuery = findSkyTeamFlights.belongsTo
                .foldExactOrNone(
                    consortium -> consortium.id,
                    () -> null
        );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQuery);

        // CALL 3rd party system
        String findSkyTeamFlightsQueryFor3rdParty = findSkyTeamFlights.belongsTo
                .foldExactOrNone(
                    consortium -> consortium.id,
                    () -> " "
                );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQueryFor3rdParty);
    }

    public static void none() {
        var findAllFlights = new FlightSearch(
                ZonedDateTime.now(),
                ConsortiumCriteria.none()
        );

        String findAllFlightsQuery = findAllFlights.belongsTo.foldExactOrNone(
                consortium -> consortium.id,
                () -> null
        );

        System.out.println("find All Flights Query: " + findAllFlightsQuery);

        // CALL 3rd party system
        String findSkyTeamFlightsQueryFor3rdParty = findAllFlights.belongsTo.foldExactOrNone(
                consortium -> consortium.id,
                () -> " "
        );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQueryFor3rdParty);
    }
}
