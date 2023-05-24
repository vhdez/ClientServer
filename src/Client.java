import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client is running.");
        try {
            Socket socketClientSide = new Socket("192.168.5.10", 5000);
            ObjectOutputStream dataWriter = new ObjectOutputStream(socketClientSide.getOutputStream());
            dataWriter.writeObject("Hi everyone!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Darn... the client crashed.");
        }

    }
}
