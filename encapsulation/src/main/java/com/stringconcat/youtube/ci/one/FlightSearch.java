package com.stringconcat.youtube.ci.one;

import java.time.ZonedDateTime;
import java.util.Optional;

class FlightSearch {

    public ZonedDateTime startsAt;

    private Alliance belongsTo;

    public FlightSearch(
            final ZonedDateTime startsAt,
            final Alliance belongsTo
    ) {
        this.startsAt = startsAt;
        this.belongsTo = belongsTo;
    }

    public Optional<Alliance> belongsTo() {
        return Optional.ofNullable(belongsTo);
    }
}
