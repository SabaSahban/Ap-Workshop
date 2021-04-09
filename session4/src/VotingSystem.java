import java.util.ArrayList;
import java.util.Iterator;
import ir.huri.jcal.JalaliCalendar;
/**
 * Voting system simullation.
 * @author sabasahban
 * @since 1400-01-21
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem() {
        votingList = new ArrayList<Voting>();
    }

    /**
     * Create voting .
     * @param question question of voting
     * @param type type of voting to show people can vote how many times.
     * @param why list of choices in voting.
     */
    public void creatiVoting(String question, int type, ArrayList<String> why) {
        Voting voting=new Voting(type,question);
        Iterator<String > it=why.iterator();
        while(it.hasNext()){
            voting.createPoll(it.next());
        }
        votingList.add(voting);
    }

    /**
     * Add vote to voting
     * @param index index of voting in system.
     * @param person voter.
     * @param choice all choices of voter.
     */
    public void vote(int index, Person person, ArrayList<String> choice) {
        votingList.get(index).vote(person,choice);

    }
    //question s of voting

    /**
     * show all voting question in this system.
     */
    public void printVotingList(){
        for (Voting i:votingList
        ) {
            System.out.println("question : "+i.getQuestion());
        }
    }

    /**
     * result of each voting.
     * @param index index of voting we want.
     */
    public void printResult(int index){
        votingList.get(index).printVotes();
    }

    /**
     * print question and choices in voting.
     * @param index index of voting.
     */
    public void printVoting(int index){
        votingList.get(index).printChoices();

    }

    /**
     * print voters list
     * @param index index of voting
     *
     */
    public void printVoter(int index){
        votingList.get(index).printVoters();

    }


}
