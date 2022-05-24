package com.stringconcat.youtube.ci.two;

import java.time.ZonedDateTime;

class FlightSearch {

    public ZonedDateTime startsAt;

    public ConsortiumCriteria belongsTo;

    public FlightSearch(
            final ZonedDateTime startsAt,
            final ConsortiumCriteria belongsTo
    ) {
        this.startsAt = startsAt;
        this.belongsTo = belongsTo;
    }
}
