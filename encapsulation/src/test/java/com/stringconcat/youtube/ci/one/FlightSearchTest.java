package com.stringconcat.youtube.ci.one;

import com.stringconcat.youtube.ci.one.business.Consortium;
import com.stringconcat.youtube.ci.one.business.FlightSearch;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

class FlightSearchTest {

    @Test
    void test() {
        // API
        var findSkyTeamFlights = new FlightSearch(
                ZonedDateTime.now(),
                new Alliance("SkyTeam")
        );

        // DATABASE
        String findSkyTeamFlightsQuery = findSkyTeamFlights.belongsTo!=null?findSkyTeamFlights.belongsTo.id:" ";
    }
}