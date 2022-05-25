package com.stringconcat.youtube.ci.advanced;

import java.util.function.Function;
import java.util.function.Supplier;

class AllianceCriteria {

    private final Criteria criteria;

    public AllianceCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public <T> T foldExactOrNone(
            Function<Alliance, T> applyIfExact,
            Supplier<T> applyIfNone
    ) {
        if (criteria instanceof Criteria.Exact) {
            return applyIfExact.apply(((Criteria.Exact) criteria).alliance);
        } else if (criteria instanceof Criteria.None) {
            return applyIfNone.get();
        } else {
            throw new IllegalArgumentException("ooops");
        }
    }

    interface Criteria {
        class Exact implements Criteria {
            public final Alliance alliance;

            public Exact(final Alliance alliance) {
                this.alliance = alliance;
            }
        }

        class None implements Criteria { }
    }



    static AllianceCriteria exact(final Alliance alliance) {
        return new AllianceCriteria(new Criteria.Exact(alliance));
    }

    static AllianceCriteria none() {
        return new AllianceCriteria(new Criteria.None());
    }
}
