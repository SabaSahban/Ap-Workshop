import ir.huri.jcal.JalaliCalendar;

import java.util.*;

/**
 * make one voting with question and choices.
 */
public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> polls;

    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * create new choice for voting.
     * @param choice choice of voting.
     */
    public void createPoll(String choice) {
        polls.put(choice,new HashSet<>());
    }

    /**
     * sumbit new vote .
     * @param person voter
     * @param choice list of all choices of voter.
     *               sumbit vote and check type of vote.
     *               and add voter to voters list.
     */
    public void vote(Person person, ArrayList<String> choice) {
        JalaliCalendar jalaliCalendar = new JalaliCalendar(new GregorianCalendar());
        Vote vote = new Vote(person, jalaliCalendar.toString());
        if ((type == 0 && (choice.size() == 1)) || type == 1) {
            for (String i:choice) {
                HashSet<Vote> vote1 = polls.get(i);
                if (vote1 == null) {
                    System.out.println("hi");
                    vote1 = new HashSet<>();
                }

                vote1.add(vote);
                polls.put(i, vote1);
                voters.add(person);
            }
        } else {
            System.out.println("person has incorrect type of vote");

        }


    }

    /**
     * show votes result.
     * and all choices and how many votes they have.
     */
    public void printVotes() {
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(question + ": ");
        int counter=1;
        for (Map.Entry<String, HashSet<Vote>> entry : polls.entrySet()) {
            HashSet<Vote> test = entry.getValue();
            map.put(entry.getKey(), entry.getValue().size());
            System.out.println(counter+++"-choice : " + entry.getKey() + " number of vote " + test.size());
            for (Vote i : test) {
                System.out.println(i.getPerson().toString() + " Date: " + i.getDate());
            }

        }
        int max = Collections.max(map.values());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("result is :" + entry.getKey());
            }
        }
    }

    /**
     * show voting question and choices.
     */
    public void printChoices() {
        System.out.println(question + ": ");
        ArrayList<String> test = getPolls();
        int counter = 1;
        for (String i : test
        ) {
            System.out.println(counter++ + "- choice: " + i);
        }
        System.out.println(counter++  + " - Random");
        if (type == 1) {
            System.out.println(counter  + " - exit");
        }
    }

    /**
     * get all choices.
     * @return array list of selectable choices.
     */
    public ArrayList<String> getPolls() {
        ArrayList<String> choice = new ArrayList<>();
        for (Map.Entry<String, HashSet<Vote>> entry : polls.entrySet()) {
            choice.add(entry.getKey());
        }
        return choice;
    }

    /**
     * print all people vote this voting.
     */
    public void printVoters() {
        for (Person i : voters
        ) {
            System.out.println(i.toString());

        }
    }
}
