package com.stringconcat.youtube.ci.end;

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

        String sql = String.format(
                "Insert into FLIGHT_SEARCH (alliance) VALUES (%s)",
                allianceAsString
        );

        // CALL 3rd party system
        String allianceAsStringForGet = findAlliance.belongsTo
                .foldExactOrNone(
                    alliance -> alliance.id,
                    () -> " "
                );
        var getRequest = "/flights?alliance="+allianceAsStringForGet;

    }

}
