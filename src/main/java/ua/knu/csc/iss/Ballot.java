package ua.knu.csc.iss;

import java.util.List;

public class Ballot {
    private String ballotId;           // Unique identifier for the ballot
    private String electionId;         // Associated election ID
    private List<Option> options;      // List of voting options (candidates, proposals, etc.)

    // Constructor
    public Ballot(String ballotId, String electionId, List<Option> options) {
        this.ballotId = ballotId;
        this.electionId = electionId;
        this.options = options;
    }

    // Getters
    public String getBallotId() {
        return ballotId;
    }

    public String getElectionId() {
        return electionId;
    }

    public List<Option> getOptions() {
        return options;
    }

    // Method to display ballot details
    public void displayBallot() {
        System.out.println("Ballot ID: " + ballotId);
        System.out.println("Election ID: " + electionId);
        System.out.println("Voting Options:");
        for (Option option : options) {
            System.out.println(" - " + option.getDescription() + " (ID: " + option.getOptionId() + ")");
        }
    }

    // Method to check if an option exists in the ballot
    public boolean isOptionPresent(String optionId) {
        return options.stream().anyMatch(option -> option.getOptionId().equals(optionId));
    }
}
