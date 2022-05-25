package com.stringconcat.youtube.ci.interf;

import java.util.function.Function;
import java.util.function.Supplier;

abstract class AllianceCriteria {

    public abstract  <T> T foldExactOrNone(
            Function<Alliance, T> applyIfExact,
            Supplier<T> applyIfNone
    );

    static AllianceCriteria exact(final Alliance alliance)

    static AllianceCriteria none()
}
