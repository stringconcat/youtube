package com.stringconcat.youtube.ci.zero;

import java.time.ZonedDateTime;

public class Main {

    public static void exact() {
        // API
        var findAlliance = new FlightSearch(
                ZonedDateTime.now(),
                new Alliance("SkyTeam")
        );

        var findNoAlliance = new FlightSearch(
                ZonedDateTime.now(),
                null
        );

        // DATABASE
        String allianceAsString = findAlliance.belongsTo!=null?findAlliance.belongsTo.id:" ";

        String sql = "Insert into FLIGHT_SEARCH (alliance) VALUES ("+allianceAsString+")";

        System.out.println("find Sky Team Flights Query: " + sql);
    }
}
