package com.stringconcat.youtube.ci.end;

import kotlin.Pair;

import java.time.ZonedDateTime;
import java.util.List;

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
        List<String> findSkyTeamFlightsQuery = findSkyTeamFlights.belongsTo.fold(
                consortium -> List.of(consortium.id),
                () -> List.of()
        );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQuery);

        // CALL 3rd party system
        String findSkyTeamFlightsQueryFor3rdParty = findSkyTeamFlights.belongsTo.fold(
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

        String findAllFlightsQuery = findAllFlights.belongsTo.fold(
                consortium -> consortium.id,
                () -> null
        );

        System.out.println("find All Flights Query: " + findAllFlightsQuery);

        // CALL 3rd party system
        String findSkyTeamFlightsQueryFor3rdParty = findAllFlights.belongsTo.fold(
                consortium -> consortium.id,
                () -> " "
        );

        System.out.println("find Sky Team Flights Query: " + findSkyTeamFlightsQueryFor3rdParty);
    }
}
