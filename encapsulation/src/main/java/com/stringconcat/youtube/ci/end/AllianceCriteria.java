package com.stringconcat.youtube.ci.end;

import java.util.function.Function;
import java.util.function.Supplier;

final class AllianceCriteria {

    private final Alliance shouldBelongTo; //Nullable

    private AllianceCriteria(final Alliance shouldBelongTo) {
        this.shouldBelongTo = shouldBelongTo;
    }

    public <T> T foldExactOrNone(
            Function<Alliance, T> applyIfExact,
            Supplier<T> applyIfNone
    ) {
        if (null != shouldBelongTo) {
            return applyIfExact.apply(shouldBelongTo);
        } else {
            return applyIfNone.get();
        }
    }

    public static AllianceCriteria exact(Alliance shouldBelongTo) {
        return new AllianceCriteria(shouldBelongTo);
    }

    public static AllianceCriteria none() {
        return new AllianceCriteria(null);
    }
}
