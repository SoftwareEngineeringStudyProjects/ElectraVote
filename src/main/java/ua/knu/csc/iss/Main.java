package ua.knu.csc.iss;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = "res/demo-messenger-vote (Відповіді) - Відповіді форми (1).csv";
        List<Ballot> ballots = VotingReader.readVotingResults(filePath);
        Election election = new Election("E1", ballots);
        election.printResults();

    }
}