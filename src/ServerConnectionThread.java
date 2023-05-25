import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionThread implements Runnable {
    public void run() {
        try {
            ServerSocket connectionSocket = new ServerSocket(5000);
            System.out.println("Server is running...");
            while (!Thread.interrupted()) {
                Socket socketServerSide = connectionSocket.accept();
                System.out.println("Server has new client...");
                ObjectInputStream dataReader = new ObjectInputStream(socketServerSide.getInputStream());
                Thread perClientReadingThread = new Thread(new ClientReadingThread(dataReader));
                perClientReadingThread.start();
            }
        } catch (Exception ex) {
            System.out.println("ServerConnectionThread crashed: " + ex);
        }
    }
}
