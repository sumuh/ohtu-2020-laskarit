package statistics;

import statistics.matcher.*;

public class QueryBuilder {

    Matcher build;

    public QueryBuilder() {
        this.build = new All();
    }

    public Matcher build() {

        Matcher oldBuild = build;
        build = new All();
        return oldBuild;

    }

    public QueryBuilder playsIn(String team) {
        Matcher m = new And(build, new PlaysIn(team));
        this.build = m;
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        Matcher m = new And(build, new HasAtLeast(value, category));
        this.build = m;
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        Matcher m = new And(build, new HasFewerThan(value, category));
        this.build = m;
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        Matcher m = new Or(m1, m2);
        this.build = m;
        return this;
    }

}
