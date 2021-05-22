
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    private ArrayList<String> options;
    private ArrayList<String> fileNames;
    private int numberOfNotes ;

    /**
     * constructor of system
     */
    public FileUtils() {
        options = new ArrayList<>();
        fileNames = getFileNamesArr();
    }

    /**
     * set number of notes with size of arraylist of file names
     */
    public void setNumberOfNotes(){
        numberOfNotes = fileNames.size();
    }

    /**
     * add options to menu
     * @param args
     */
    public void addOptions(String... args) {
        for (String string : args) {
            options.add(string);
        }
    }

    /**
     * print all options
     */
    public void printOptions() {
        int i = 0;
        for (String string : options) {
            java.lang.System.out.println(i + "- " + string);
            i++;
        }
    }

    /**
     * after user decides to do a work from options
     * this method calls proper method related to that choice
     * @param index
     */
    public void action(int index) {
        switch (index) {
            case 0: {
                createNewNote();
                break;
            }
            case 1: {
                showAllNotes();
                break;
            }
            case 2: {
                readFile(chooseANote());
                break;
            }
            case 3: {
                deleteFile(chooseANote());
                break;
            }
        }
    }

    /**
     * delete a file that has given name
     * reduce the numberOfNotes
     * remove name of that file from names of notes array list
     * @param name
     */
    public void deleteFile(String name){
        File file = new File(name);
        file.delete();
        fileNames.remove(name.replaceFirst(".txt",""));
        numberOfNotes--;
    }

    /**
     * read a note file that has given name
     * print date and title and content of that note
     * @param name
     */
    public void readFile(String name){

        int i = 0;
        try (FileInputStream file = new FileInputStream(name);
             ObjectInputStream object = new ObjectInputStream(file)) {
            Note note = (Note) object.readObject();
            System.out.println("Date modified : " + note.getDate());
            System.out.println("Title : " + note.getTitle());
            System.out.println(note.getNote());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        java.lang.System.out.println();

    }

    /**
     * create new note file
     * the name of that file is title of that note
     */
    public void createNewNote() {
        numberOfNotes++;
        java.lang.System.out.println("Enter title");
        Scanner sc = new Scanner(java.lang.System.in);
        String title = sc.nextLine();
        System.out.println("Enter note");
        String note = sc.nextLine();
        String fileName = title + ".txt";
        try (FileOutputStream file = new FileOutputStream(fileName);
             ObjectOutputStream object = new ObjectOutputStream(file)) {
            object.writeObject(new Note(title,note));
            fileNames.add(title);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * show name and date and first 6 characters of the note
     */
    public void showAllNotes() {
        int index = 0;
        while (index < numberOfNotes) {
            try (FileInputStream fi = new FileInputStream(new File((fileNames.get(index)) + ".txt"));
                 ObjectInputStream oi = new ObjectInputStream(fi)) {
                Note note = (Note) oi.readObject();
                System.out.print(note.getDate() + "  ");
                java.lang.System.out.print(fileNames.get(index) + "-   ");
                if (note.getNote().length() > 6)
                    System.out.print(note.getNote().substring(0,6) );
                else
                    System.out.print(note.getNote());
                java.lang.System.out.println("...");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            index++;
        }
    }

    /**
     * print options
     * return number of the option that user chooses
     * @return
     */
    public int chooseOption() {
        printOptions();
        Scanner sc = new Scanner(java.lang.System.in);
        int choice = sc.nextInt();
        while (choice >= options.size() || choice < 0) {
            java.lang.System.out.println("invalid number.try again");
            printOptions();
            choice = sc.nextInt();
        }
        return choice;
    }

    /**
     * the general loop of program
     * in each round checks the chosen options is not exit then call the action method
     */
    public void run() {
        setNumberOfNotes();
        int index = chooseOption();
        while (index != options.size() - 1) {
            action(index);
            index = chooseOption();
        }
    }

    /**
     * return name of a chosen file from all notes
     * @return
     */
    public String chooseANote(){
        showAllNotes();
        Scanner sc = new Scanner(java.lang.System.in);
        java.lang.System.out.println("enter name of note");
        String titleName = sc.next();
        if (!(fileNames.contains(titleName))){
            System.out.println("wrong name .Enter again");
            titleName = sc.next();
        }
        return titleName + ".txt";
    }

    /**
     * find text files and return their names as an arraylist
     * @return
     */
    public ArrayList getFileNamesArr(){
        ArrayList<String> textFiles = new ArrayList<>();
        File userDir = new File(".");
        for (File file : userDir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                textFiles.add(file.getName().replaceFirst(".txt" , ""));
            }
        }
        return textFiles;
    }

}
