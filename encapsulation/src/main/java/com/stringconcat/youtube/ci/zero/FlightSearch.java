package com.stringconcat.youtube.ci.zero;

import org.jetbrains.annotations.Nullable;

import java.time.ZonedDateTime;

class FlightSearch {

    public ZonedDateTime startsAt;

    @Nullable
    public Alliance belongsTo;

    public FlightSearch(
            final ZonedDateTime startsAt,
            @Nullable final Alliance belongsTo
    ) {
        this.startsAt = startsAt;
        this.belongsTo = belongsTo;
    }
}