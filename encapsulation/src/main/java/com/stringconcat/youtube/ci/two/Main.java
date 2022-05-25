package com.stringconcat.youtube.ci.two;

import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        exact();
        none();
    }

    public static void exact() {
        // API
        var findAlliance = new FlightSearch(
                ZonedDateTime.now(),
                AllianceCriteria.exact(new Alliance("SkyTeam"))
        );

        var findAlliance = new FlightSearch(
                ZonedDateTime.now(),
                AllianceCriteria.none()
        );

        // DATABASE
        String allianceAsString;
        if (findAlliance.belongsTo instanceof AllianceCriteria.Exact) {
            allianceAsString = ((AllianceCriteria.Exact) findAlliance.belongsTo).alliance.id;
        } else if (findAlliance.belongsTo instanceof AllianceCriteria.None) {
            allianceAsString = "no one";
        } else {
            throw new IllegalArgumentException("ooops");
        }

        String sql = "Insert into FLIGHT_SEARCH (alliance) VALUES ("+allianceAsString+")";

        System.out.println("find Sky Team Flights Query: " + sql);

    }
}
