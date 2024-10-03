package ua.knu.csc.iss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallotTest {

    private Ballot ballot;
    private String ballotId;
    private String electionId;
    private List<Option> options;

    @BeforeEach
    void setUp() {
        ballotId = "B123";
        electionId = "E456";
        //options = Arrays.asList(new Option("Option 1"), new Option("Option 2"));
        options = new ArrayList<>();
        options.add(new Option("1", "Vote for Alice"));
        options.add(new Option("2", "Vote for Bob"));
        options.add(new Option("3", "Proposal A: Increase funding for parks"));
        options.add(new Option("4", "Proposal B: New public transport system"));

        ballot = new Ballot(ballotId, electionId, options);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(ballotId, ballot.getBallotId(), "Ballot ID should match the constructor input");
        assertEquals(electionId, ballot.getElectionId(), "Election ID should match the constructor input");
        assertEquals(options, ballot.getOptions(), "Options should match the constructor input");
    }

    @Test
    void getOptions() {
        assertEquals(4, ballot.getOptions().size());
        assertEquals("1", ballot.getOptions().get(0).getOptionId());
    }

    @Test
    void isOptionPresent() {
        assertTrue(ballot.isOptionPresent("1"), "Option 1 should be present in the ballot");
        assertTrue(ballot.isOptionPresent("4"), "Option 4 should be present in the ballot");
        assertFalse(ballot.isOptionPresent("01"), "Option O should not be present in the ballot");
        assertFalse(ballot.isOptionPresent(""), "Empty option should not be present in the ballot");

    }
}