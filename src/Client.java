import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client is running.");
        try {
            Socket socketClientSide = new Socket("10.37.159.46", 5000);
            ObjectOutputStream dataWriter = new ObjectOutputStream(socketClientSide.getOutputStream());
            dataWriter.writeObject(5);
            dataWriter.writeObject("Hi 1!!!!!");
            dataWriter.writeObject("Hi 2!!!!!");
            dataWriter.writeObject("Hi 3!!!!!");
            dataWriter.writeObject("Hi 4!!!!!");
            dataWriter.writeObject("Hi 5!!!!!");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Darn... the client crashed.");
        }

    }
}
