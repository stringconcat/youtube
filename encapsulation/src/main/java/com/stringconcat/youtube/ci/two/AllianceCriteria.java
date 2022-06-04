package com.stringconcat.youtube.ci.two;

interface AllianceCriteria {

    class Exact implements AllianceCriteria {
        public final Alliance alliance;

        public Exact(final Alliance alliance) {
            this.alliance = alliance;
        }
    }

    class None implements AllianceCriteria { }

    static AllianceCriteria exact(final Alliance alliance) {
        return new Exact(alliance);
    }

    static AllianceCriteria none() {
        return new None();
    }
}
