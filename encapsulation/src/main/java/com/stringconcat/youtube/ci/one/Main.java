package com.stringconcat.youtube.ci.one;

import java.time.ZonedDateTime;

public class Main {

    public static void exact() {
        // API

        var findAlliance = new FlightSearch(
                ZonedDateTime.now(),
                new Alliance("SkyTeam")
        );

        var findAlliance = new FlightSearch(
                ZonedDateTime.now(),
                null
        );

        // DATABASE
        String allianceAsString = findAlliance.belongsTo()
            .map(alliance -> alliance.id)
            .orElse("no one");

        String sql = String.format(
                "Insert into FLIGHT_SEARCH (alliance) VALUES (%s)",
                allianceAsString
        );

        System.out.println(sql);
    }

}
