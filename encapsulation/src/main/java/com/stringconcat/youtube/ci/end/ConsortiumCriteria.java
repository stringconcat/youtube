package com.stringconcat.youtube.ci.end;

import java.util.function.Function;
import java.util.function.Supplier;

final class ConsortiumCriteria {

    private final Consortium shouldBelongTo; //Nullable

    private ConsortiumCriteria(final Consortium shouldBelongTo) {
        this.shouldBelongTo = shouldBelongTo;
    }

    public <T> T fold(
            Function<Consortium, T> applyIfExact,
            Supplier<T> applyIfNone
    ) {
        if (null != shouldBelongTo) {
            return applyIfExact.apply(shouldBelongTo);
        } else {
            return applyIfNone.get();
        }
    }

    public static ConsortiumCriteria exact(Consortium shouldBelongTo) {
        return new ConsortiumCriteria(shouldBelongTo);
    }

    public static ConsortiumCriteria none() {
        return new ConsortiumCriteria(null);
    }
}
