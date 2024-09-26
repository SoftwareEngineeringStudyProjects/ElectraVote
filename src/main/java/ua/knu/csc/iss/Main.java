package ua.knu.csc.iss;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");
        System.out.print("received args count = " + args.length);

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        List<Option> options = new ArrayList<>();
        options.add(new Option("1", "Vote for Alice"));
        options.add(new Option("2", "Vote for Bob"));
        options.add(new Option("3", "Proposal A: Increase funding for parks"));
        options.add(new Option("4", "Proposal B: New public transport system"));

        Ballot ballot = new Ballot("B001", "E001", options);
        ballot.displayBallot();
    }
}