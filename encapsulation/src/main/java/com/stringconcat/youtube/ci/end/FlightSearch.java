package com.stringconcat.youtube.ci.end;

import java.time.ZonedDateTime;

class FlightSearch {

    public ZonedDateTime startsAt;

    public AllianceCriteria belongsTo;

    public FlightSearch(
            final ZonedDateTime startsAt,
            final AllianceCriteria belongsTo
    ) {
        this.startsAt = startsAt;
        this.belongsTo = belongsTo;
    }
}
