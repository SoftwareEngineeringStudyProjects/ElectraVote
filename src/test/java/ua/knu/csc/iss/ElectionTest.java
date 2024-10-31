package ua.knu.csc.iss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ElectionTest {

    private Election election;
    private Option optionAlice;
    private Option optionBob;
    private Option optionCharlie;

    @BeforeEach
    public void setUp() {
        election = new Election("Election2024");
        optionAlice = new Option("1", "Alice");
        optionBob = new Option("2", "Bob");
        optionCharlie = new Option("3", "Charlie");
    }

    @Test
    public void testCalculateResultsWithMultipleBallots() {
        // Adding ballots
        election.addBallot(new Ballot("B1", "Election2024", Arrays.asList(optionAlice, optionBob)));
        election.addBallot(new Ballot("B2", "Election2024", Arrays.asList(optionAlice)));
        election.addBallot(new Ballot("B3", "Election2024", Arrays.asList(optionBob, optionCharlie)));
        election.addBallot(new Ballot("B4", "Election2024", Arrays.asList(optionAlice, optionCharlie)));

        // Expected results
        Map<String, Integer> expectedResults = new HashMap<>();
        expectedResults.put("1", 3); // Alice
        expectedResults.put("2", 2); // Bob
        expectedResults.put("3", 2); // Charlie

        // Calculate actual results
        Map<String, Integer> actualResults = election.calculateResults();

        // Assert results
        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void testCalculateResultsWithNoBallots() {
        // Expected results should be empty
        Map<String, Integer> expectedResults = new HashMap<>();

        // Calculate actual results
        Map<String, Integer> actualResults = election.calculateResults();

        // Assert results
        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void testCalculateResultsWithSingleBallot() {
        // Adding a single ballot
        election.addBallot(new Ballot("B1", "Election2024", Arrays.asList(optionAlice)));

        // Expected results
        Map<String, Integer> expectedResults = new HashMap<>();
        expectedResults.put("1", 1); // Alice

        // Calculate actual results
        Map<String, Integer> actualResults = election.calculateResults();

        // Assert results
        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void testCalculateResultsWithDuplicateBallots() {
        // Adding duplicate ballots
        election.addBallot(new Ballot("B1", "Election2024", Arrays.asList(optionAlice)));
        election.addBallot(new Ballot("B2", "Election2024", Arrays.asList(optionAlice)));

        // Expected results
        Map<String, Integer> expectedResults = new HashMap<>();
        expectedResults.put("1", 2); // Alice

        // Calculate actual results
        Map<String, Integer> actualResults = election.calculateResults();

        // Assert results
        assertEquals(expectedResults, actualResults);
    }
}