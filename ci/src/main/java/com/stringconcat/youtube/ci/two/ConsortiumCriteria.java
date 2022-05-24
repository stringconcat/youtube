package com.stringconcat.youtube.ci.two;

interface ConsortiumCriteria {

    class Exact implements ConsortiumCriteria {
        public final Consortium consortium;

        public Exact(final Consortium consortium) {
            this.consortium = consortium;
        }
    }

    class None implements ConsortiumCriteria {

    }

    static ConsortiumCriteria exact(final Consortium consortium) {
        return new Exact(consortium);
    }

    static ConsortiumCriteria none() {
        return new None();
    }
}
