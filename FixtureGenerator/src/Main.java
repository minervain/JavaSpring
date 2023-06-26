import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Takım 1");
        teams.add("Takım 2");
        teams.add("Takım 3");
        teams.add("Takım 4");
        teams.add("Takım 5");
        teams.add("Takım 6");

        Main fixtureGenerator = new Main();
        List<Fixture> fixtures = fixtureGenerator.generateFixtures(teams);

        for (Fixture fixture : fixtures) {
            System.out.println(fixture.getHomeTeam() + " vs " + fixture.getAwayTeam());
        }
    }

    public List<Fixture> generateFixtures(List<String> teams) {
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int totalRounds = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        List<Fixture> fixtures = new ArrayList<>();

        for (int round = 0; round < totalRounds; round++) {
            for (int match = 0; match < matchesPerRound; match++) {
                String homeTeam;
                String awayTeam;

                if (round % 2 == 0) {
                    homeTeam = teams.get(match);
                    awayTeam = teams.get(teams.size() - 1 - match);
                } else {
                    awayTeam = teams.get(match);
                    homeTeam = teams.get(teams.size() - 1 - match);
                }

                fixtures.add(new Fixture(homeTeam, awayTeam));
            }

            Collections.rotate(teams.subList(1, teams.size()), 1);
        }

        return fixtures;
    }

    public class Fixture {
        private String homeTeam;
        private String awayTeam;

        public Fixture(String homeTeam, String awayTeam) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
        }

        public String getHomeTeam() {
            return homeTeam;
        }

        public String getAwayTeam() {
            return awayTeam;
        }
    }
}