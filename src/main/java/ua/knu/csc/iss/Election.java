package ua.knu.csc.iss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Election {
    private String electionId;
    private List<Ballot> ballots;

    public Election(String electionId) {
        this.electionId = electionId;
        this.ballots = new ArrayList<>();
    }

    public void addBallot(Ballot ballot) {
        ballots.add(ballot);
    }

    public Map<String, Integer> calculateResults() {
        Map<String, Integer> results = new HashMap<>();

        for (Ballot ballot : ballots) {
            for (Option option : ballot.getOptions()) {
                String optionId = option.getOptionId();
                results.put(optionId, results.getOrDefault(optionId, 0) + 1);
            }
        }

        return results;
    }

    public String getElectionId() {
        return electionId;
    }

    public List<Ballot> getBallots() {
        return ballots;
    }
}
