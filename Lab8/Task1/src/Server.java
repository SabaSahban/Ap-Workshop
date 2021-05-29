import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/*
  This class represents a server
 */

/**
 * @author Saba Sahban
 */

public class Server {
    public static void main(String[] args) {


        //create new server socket using given port
        try (ServerSocket welcomingSocket = new ServerSocket(5757)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            //server waits to be accepted
            try (Socket connectionSocket = welcomingSocket.accept()) {
                System.out.println("client accepted!");
                //read and write from socket
                OutputStream out = connectionSocket.getOutputStream();
                InputStream in = connectionSocket.getInputStream();
                byte[] buffer = new byte[2048];

                String message = "message";

                //receive and send messages until server sends over
                while(!message.equals("over")) {
                    int read = in.read(buffer);
                    message = new String(buffer, 0, read);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("RECV from client: " +message);
                    //send received messages back to server
                    out.write(message.getBytes());
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("SENT: " + message);
                }
                TimeUnit.SECONDS.sleep(1);
            }

            catch (IOException ex) {
                System.err.println(ex);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}
