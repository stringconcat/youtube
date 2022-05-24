package com.stringconcat.youtube.ci.one;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightSearchTest {

    @Test
    void test() {
        // API
        var findSkyTeamFlights = new FlightSearch(
                ZonedDateTime.now(),
                new Consortium("SkyTeam")
        );

        // DATABASE
        String findSkyTeamFlightsQuery = findSkyTeamFlights.belongsTo!=null?findSkyTeamFlights.belongsTo.id:" ";
    }
}