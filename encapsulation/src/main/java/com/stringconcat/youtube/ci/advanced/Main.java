package com.stringconcat.youtube.ci.advanced;

import java.time.ZonedDateTime;

public class Main {

    public static void exact() {
        // API
        var findAlliance = new FlightSearch(
                ZonedDateTime.now(),
                AllianceCriteria.exact(new Alliance("SkyTeam"))
        );

        // DATABASE
        String allianceAsString = findAlliance.belongsTo
                .foldExactOrNone(
                        alliance -> alliance.id,
                    () -> null
        );

        String sql = "Insert into FLIGHT_SEARCH (alliance) VALUES ("+allianceAsString+")";

        System.out.println("find Sky Team Flights Query: " + sql);

        // CALL 3rd party system
        String allianceAsStringForGet = findAlliance.belongsTo
                .foldExactOrNone(
                        alliance -> alliance.id,
                    () -> " "
                );
        var getRequest = "/flights?alliance="+allianceAsStringForGet;

    }

}
