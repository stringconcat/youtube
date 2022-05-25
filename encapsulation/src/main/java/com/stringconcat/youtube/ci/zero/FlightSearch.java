package com.stringconcat.youtube.ci.zero;

import java.time.ZonedDateTime;

class FlightSearch {

    public ZonedDateTime startsAt;

    public Alliance belongsTo;

    public FlightSearch(
            final ZonedDateTime startsAt,
            final Alliance belongsTo
    ) {
        this.startsAt = startsAt;
        this.belongsTo = belongsTo;
    }
}
