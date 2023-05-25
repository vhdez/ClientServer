import java.io.IOException;
import java.io.ObjectInputStream;

public class ClientReadingThread implements Runnable {
    ObjectInputStream dataReader;

    public ClientReadingThread(ObjectInputStream dataReader) {
        this.dataReader = dataReader;
    }

    @Override
    public void run() {
        try {
        while (!Thread.interrupted()) {
            int dataCount = -1;
            try {
                dataCount = (Integer) dataReader.readObject();
            } catch (IOException ex) {
                Thread.currentThread().yield();
            }
            for (int i = 0; i < dataCount; i = i + 1) {
                Object data = null;
                while (data == null) {
                    try {
                        data = dataReader.readObject();
                    } catch (IOException ex) {
                        Thread.currentThread().yield();
                    }
                }
                System.out.println(data);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Darn... the server crashed!");
    }

}
}
