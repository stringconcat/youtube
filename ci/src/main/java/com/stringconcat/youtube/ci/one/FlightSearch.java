package com.stringconcat.youtube.ci.one;

import java.time.ZonedDateTime;

class FlightSearch {

    public ZonedDateTime startsAt;

    public Consortium belongsTo;

    public FlightSearch(
            final ZonedDateTime startsAt,
            final Consortium belongsTo
    ) {
        this.startsAt = startsAt;
        this.belongsTo = belongsTo;
    }
}
