import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // create new voting system
        VotingSystem votingSystem = new VotingSystem();
        //add persons
        Person mohamad = new Person("Saba", "sahban");
        ArrayList<String> sabaChoices = new ArrayList<>();
        Person k = new Person("K", "AK");
        ArrayList<String> kChoices = new ArrayList<>();
        ArrayList<String> choice1 = new ArrayList<>();
        // add choices of votings
        choice1.add("Edalat");
        choice1.add("kalbasi");
        choice1.add("Zeynali");
        ArrayList<String> choice = new ArrayList<>();
        choice.add("openuni");
        choice.add("Stayhome");
        choice.add("both");
        // create two voting
        votingSystem.creatiVoting("Best Ap teacher?", 1, choice1);
        votingSystem.creatiVoting("Do you perefer stay home or university", 0, choice);
        System.out.println("saba your turn");
        votingSystem.printVoting(0);
        Scanner scanner = new Scanner(System.in);
        // scan first voter option until end
        String i = scanner.next();
        while (!i.equals("5")) {
            if (i.equals("4")) {
                // random choice
                Random r = new Random();
                int j = r.nextInt(2);
                sabaChoices.add(choice1.get(j));
            } else {
                sabaChoices.add(i);
            }
            i = scanner.next();
        }
        //add vote to system
        votingSystem.vote(0, mohamad, sabaChoices);
        System.out.println("k your turn");
        votingSystem.printVoting(0);
        i = scanner.next();
        // scan second voter votes
        while (!i.equals("5")) {
            if (i.equals("4")) {
                Random r = new Random();
                int j = r.nextInt(2);
                kChoices.add(choice1.get(j));
            } else {
                kChoices.add(i);
            }
            i = scanner.next();
        }
        // add vote to system
        votingSystem.vote(0, k, kChoices);
        votingSystem.printResult(0);
//        votingSystem.printVoter(0);
        System.out.println("second voting");
        System.out.println("saba your turn");
        votingSystem.printVoting(1);
        i = scanner.next();
        //add scond voting with type 0
        // new choices array list
        sabaChoices = new ArrayList<>();
        if (i.equals("4")) {
            //make randow if user select
            Random r = new Random();
            int  j = r.nextInt(2);
            sabaChoices.add(choice.get(j));
        } else {
            sabaChoices.add(i);
        }
        // add vote to system
        votingSystem.vote(1, mohamad, sabaChoices);
        // new second person choices arraylist
        kChoices = new ArrayList<>();

        System.out.println(" K your turn");
        votingSystem.printVoting(1);
        i = scanner.next();
        if (i.equals("4")) {
            Random r = new Random();
            int j = r.nextInt(2);
            kChoices.add(choice.get(j));
        } else {
            kChoices.add(i);
        }
        //add vote to system
        votingSystem.vote(1,k, kChoices);
        //show result
        votingSystem.printResult(1);
    }
}