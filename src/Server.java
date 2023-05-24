import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server is running.");

        try {
            ServerSocket connectionSocket = new ServerSocket(5000);
            Socket socketServerSide = connectionSocket.accept();

            ObjectInputStream dataReader = new ObjectInputStream(socketServerSide.getInputStream());
            Object firstDataEver = dataReader.readObject();
            System.out.println(firstDataEver);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Darn... the server crashed!");
        }

    }
}
