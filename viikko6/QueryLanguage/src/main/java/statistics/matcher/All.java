package statistics.matcher;

import statistics.Player;

public class All implements Matcher {

    private Matcher[] matchers;

    public All(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        boolean allMatch  = true;
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                allMatch = false;
            }
        }

        return allMatch;
    }
}
