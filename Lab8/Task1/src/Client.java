import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
  This class represents a client.
 */

/**
 * @author Saba Sahban
 */

public class Client {

    public static void main(String[] args) {
        //create new socket and connect to local host
        try (Socket client = new Socket("127.0.0.1", 5757)){
            System.out.println("Connected to server");
            System.out.println("Type your message");

            String message;

            OutputStream out = client.getOutputStream();
            InputStream in = client.getInputStream();

            Scanner scanner = new Scanner(System.in);
            //receive and send messages until user types over
            while (!( message = scanner.nextLine()).equals("over")) {
                if (message.length() != 0) {
                    out.write(message.getBytes());
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("SENT: " + message);
                    byte[] buffer = new byte[1024];
                    int read = in.read(buffer);
                    message = new String(buffer, 0, read);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("RECV: " + message);

                }
                TimeUnit.SECONDS.sleep(1);
            }
            out.write("over".getBytes());
            System.out.println("connection closed");

        } catch (IOException | InterruptedException e){
            System.err.println(e);
            e.printStackTrace();
        }
        System.out.println("Bye :)");
    }
}
