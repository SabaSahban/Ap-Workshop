import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    private ArrayList<String> fileNames;
    public FileUtils() {
        fileNames = getFileNamesArr();
    }

    /**
     * read file
     * @param fileName
     */
    public void readFile(String fileName){
        int i = 0;
        try (FileInputStream file = new FileInputStream(fileName);
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
     * read all files
     * @param fileName
     */
    public void readAllFiles(String fileName){
        File file = new File(fileName);
        try (InputStream in = new FileInputStream(file))
        {
            int content;
            int count = 0;
            while ((content = in.read()) != -1 && count<7) {
                System.out.print((char)content);
                count ++;
            }
            System.out.println("......");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" ");
    }
    /**
     * write file
     */
    public void writeFile(String fileName){
        try{
            FileOutputStream fout=new FileOutputStream(fileName+".txt");
            System.out.println("Write your note");
            Scanner scanner = new Scanner(System.in);
            String s= scanner.nextLine();
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}
    }

    /**
     * delete file
     * @param fileName
     */
    public void deleteFile(String fileName){
        File myObj = new File(fileName+".txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + fileName+".txt");
        } else {
            System.out.println("Failed to delete the file.");
        }


    }

    /**
     * show notes
     */
    public void showNotes(){
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\Saba\\Desktop\\Lab7\\NotepadOne");
        FilenameFilter textFilefilter = new FilenameFilter(){
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        //List of all the text files
        String filesList[] = directoryPath.list(textFilefilter);
        System.out.println("List of the text files in the specified directory:");
        for(String fileName : filesList) {
            System.out.println("File Name: ");
            System.out.println(fileName);
            System.out.println("File Content: ");
            readAllFiles(fileName);
        }
    }

    /**
     * show menu to user
     */
    public void showMenu(){
        System.out.println("Choose action");
        System.out.println("1- New note");
        System.out.println("2- See all notes");
        System.out.println("3- Open a note");
        System.out.println("4- Delete a note");
        System.out.println("5- Exit");
    }
    /**
     * call methods for different menu choices
     */
    public void action(){
        boolean flag = true;
        while (flag){
            showMenu();
            System.out.println("Choose an index from shown menu");
            Scanner sc = new Scanner(System.in);
            int index =sc.nextInt();
            switch (index){
                case 1:
                    System.out.println("Enter a name for your note");
                    Scanner scanner = new Scanner(System.in);
                    String selectedName = scanner.nextLine();
                    writeFile(selectedName);
                    break;
                case 2:
                    showNotes();
                    break;

                case 3:
                    System.out.println("Enter the file name to open");
                    sc = new Scanner(System.in);
                    selectedName = sc.nextLine();
                    readFile(selectedName);
                    break;
                case 4:
                    System.out.println("Enter the file name to delete");
                    sc = new Scanner(System.in);
                    selectedName = sc.nextLine();
                    deleteFile(selectedName);
                    break;
                case 5:
                    System.out.println("Bye");
                    flag = false;
            }
        }
    }

    /**
     * get file name
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

