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

    public Election(String electionId, List<Ballot> ballots) {
        this.electionId = electionId;
        this.ballots = ballots;
    }

    public void addBallot(Ballot ballot) {
        ballots.add(ballot);
    }

    public Map<String, Integer> calculateResults() {
        Map<String, Integer> results = new HashMap<>();

        for (Ballot ballot : ballots) {
            for (Option option : ballot.getOptions()) {
                String optionDesc= option.getDescription();
                results.put(optionDesc, results.getOrDefault(optionDesc, 0) + 1);
            }
        }

        return results;
    }

    // Method to print election results sorted by vote count
    public void printResults() {
        Map<String, Integer> results = calculateResults();
        int totalVotes = ballots.size(); // Total number of ballots (votes)

        if (totalVotes == 0) {
            System.out.println("No votes cast.");
            return;
        }

        // Convert the results map to a list of Map.Entry for sorting
        List<Map.Entry<String, Integer>> sortedResults = new ArrayList<>(results.entrySet());

        // Sort the list by value (vote count) in descending order
        sortedResults.sort((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()));

        // Print header
        System.out.println("OptionName, NumberOfVotes, PercentageOfVotes");

        // Iterate over the sorted results and print them
        for (Map.Entry<String, Integer> entry : sortedResults) {
            String optionName = entry.getKey();
            int numberOfVotes = entry.getValue();
            double percentageOfVotes = ((double) numberOfVotes / totalVotes) * 100;

            // Format the output to 2 decimal places for percentage
            System.out.printf("%s, %d, %.2f%%\n", optionName, numberOfVotes, percentageOfVotes);
        }
    }

    public String getElectionId() {
        return electionId;
    }

    public List<Ballot> getBallots() {
        return ballots;
    }
}
