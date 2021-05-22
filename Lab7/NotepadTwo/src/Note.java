import java.io.*;
import java.util.Scanner;

/**
 * a class that handles notepad actions
 */

public class Note {
    /**
     * read files using bufferedReader
     * @param fileName
     */
    public void readFile(String fileName){
        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(fileName+".txt"));

            while ((strCurrentLine = objReader.readLine()) != null ) {

                System.out.println(strCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * show first characters of each file to user using bufferedReader
     * @param fileName
     * @throws IOException
     */
    public void readAllFiles(String fileName) throws IOException {

        // Read the stream
        // containing text
        FileReader fileReader
                = new FileReader(fileName);

        // Convert fileReader to
        // bufferedReader
        BufferedReader buffReader
                = new BufferedReader(
                fileReader);
        int count = 0;
        while (buffReader.ready() && count<7) {
            // Read and print characters one by one
            // by converting into character
            System.out.print((char)buffReader.read());
            count++;
        }
        System.out.println("...........");
    }

    /**
     * write a new file using buffered writer
     * @param fileName
     */
    public void writeFile(String fileName){
        BufferedWriter bw = null;
        try {
            System.out.println("Write your note");
            Scanner scanner = new Scanner(System.in);
            String mycontent= scanner.nextLine();

            //Specify the file name and path here
            File file = new File(fileName+".txt");

            /* This logic will make sure that the file
             * gets created if it is not present at the
             * specified location*/
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(mycontent);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    /**
     * delete an specific file
     * @param fileName
     */
    public void deleteFile(String fileName) throws IOException {
        File myObj = new File(fileName+".txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + fileName+".txt");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    /**
     * show all notes to user
     * @throws IOException
     */
    public void showNotes() throws IOException {
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\Saba\\Desktop\\Lab7\\NotepadTwo");
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
     *call different methods for different user choices
     * @throws IOException
     */
    public void action() throws IOException {
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
                    showNotes();
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
}

