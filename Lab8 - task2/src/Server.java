import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
  This class represents a server.
 */
/**
 * @author saba
 * @since 1400/03/08
 */
public class Server {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        int counter = 0;
        try (ServerSocket welcomingSocket = new ServerSocket(5757)) {
            System.out.print("Server started.\nWaiting for a client ... ");
            while (counter < 3) {
                Socket connectionSocket = welcomingSocket.accept();
                counter++;
                System.out.println("client accepted!");
                pool.execute(new ClientHandler(connectionSocket, counter));
            }
            pool.shutdown();
            System.out.print("done.\nClosing server ... ");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println("done.");
    }
}
class ClientHandler implements Runnable {
    private Socket connectionSocket;
    private int clientNum;
    public ClientHandler(Socket connectionSocket, int clientNum) {
        this.connectionSocket = connectionSocket;
        this.clientNum=clientNum;
    }


    @Override
    public void run() {
        try {
            OutputStream out = connectionSocket.getOutputStream();
            InputStream in = connectionSocket.getInputStream();
            byte[] buffer = new byte[2048];
            String message = "";
            while (!message.equals("over")) {
                int read = in.read(buffer);
                message = new String(buffer, 0, read);
                System.out.println("RECV from "+clientNum+": " + message);
                out.write(message.getBytes());
                System.out.println("SENT to "+clientNum+": " + message);
                Thread.sleep(2000);
            }
            System.out.print("All messages sent.\nClosing client "+clientNum);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionSocket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}