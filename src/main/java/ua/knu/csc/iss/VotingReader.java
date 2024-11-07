package ua.knu.csc.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VotingReader {

    public static void main(String[] args) {
        String filePath = "votes.csv"; // Path to the CSV file
        List<Ballot> ballots = readVotingResults(filePath);

        // Print out the results for debugging purposes
        for (Ballot ballot : ballots) {
            System.out.println("Ballot ID: " + ballot.getBallotId());
            System.out.println("Election ID: " + ballot.getElectionId());
            for (Option option : ballot.getOptions()) {
                System.out.println("Option ID: " + option.getOptionId() + ", Description: " + option.getDescription());
            }
        }
    }

    // Method to read voting results from CSV file
    public static List<Ballot> readVotingResults(String filePath) {
        List<Ballot> ballots = new ArrayList<>();
        Map<String, Option> optionMap = new HashMap<>(); // Map to track options by description
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int ballotCounter = 1; // Counter to generate unique ballot IDs

            // Skip the header line
            reader.readLine();

            // Read each line after the header
            while ((line = reader.readLine()) != null) {
                // Split line by comma
                String[] parts = line.split(",", 2); // Split timestamp and option
                if (parts.length < 2) continue; // Skip invalid lines

                String timestamp = parts[0].trim();  // Timestamp (not used in this example, but could be used in ID generation)
                String optionDescription = parts[1].trim(); // The chosen option

                // Check if the option already exists in the map
                Option option;
                if (optionMap.containsKey(optionDescription)) {
                    option = optionMap.get(optionDescription); // Reuse existing Option object
                } else {
                    // Create a new Option object and store it in the map
                    option = new Option(UUID.randomUUID().toString(), optionDescription);
                    optionMap.put(optionDescription, option);
                }

                // Create a Ballot object (you can modify electionId and ballotId logic as needed)
                Ballot ballot = new Ballot("B" + ballotCounter++, "E1", new ArrayList<>());
                ballot.getOptions().add(option);

                // Add the created ballot to the list
                ballots.add(ballot);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ballots;
    }

}
