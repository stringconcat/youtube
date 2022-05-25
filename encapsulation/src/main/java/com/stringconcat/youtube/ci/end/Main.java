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
                AllianceCriteria.exact(new Alliance("SkyTeam"))
        );

        // DATABASE
        String findSkyTeamFlightsQuery = findSkyTeamFlights.belongsTo
                .foldExactOrNone(
                        alliance -> alliance.id,
                    () -> null
        );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQuery);

        // CALL 3rd party system
        String findSkyTeamFlightsQueryFor3rdParty = findSkyTeamFlights.belongsTo
                .foldExactOrNone(
                        alliance -> alliance.id,
                    () -> " "
                );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQueryFor3rdParty);
    }

    public static void none() {
        var findAllFlights = new FlightSearch(
                ZonedDateTime.now(),
                AllianceCriteria.none()
        );

        String findAllFlightsQuery = findAllFlights.belongsTo.foldExactOrNone(
                alliance -> alliance.id,
                () -> null
        );

        System.out.println("find All Flights Query: " + findAllFlightsQuery);

        // CALL 3rd party system
        String findSkyTeamFlightsQueryFor3rdParty = findAllFlights.belongsTo.foldExactOrNone(
                alliance -> alliance.id,
                () -> " "
        );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQueryFor3rdParty);
    }
}
