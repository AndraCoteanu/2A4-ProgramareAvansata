import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Clasa SocialServer </h3>
 * <p> Defineste portul de conectare al serverului. </p>
 * <p> Serverul asteapta conexiuni din partea clientilor. </p>
 * <p> Pentru fiecare client nou conectat se va crea un fir de executie / thread. </p>
 */
public class SocialServer {
    public static final int PORT = 2121;
    private static List<ClientThread> clients = new ArrayList();
    public SocialServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("Waiting :) ... ");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException exception) {
            System.err.println("Upsiez..." + exception);
        } finally {
            serverSocket.close();
        }
    }

    public static List<ClientThread> getClients() {
        return clients;
    }
}