

public class Main {

    public static void main(String[] args) {
        FileUtils n = new FileUtils();
        n.addOptions("new note" , "see all" , "open one" , "delete a note" , "exit");
        n.run();
    }
}
