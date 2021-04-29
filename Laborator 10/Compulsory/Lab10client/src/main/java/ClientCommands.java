import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <h3> Clasa ClientCommands </h3>
 * <p> Conecteaza un nou client la server </p>
 * <p> Comunica cu serverul: ii tirmite requesturi si primeste raspunsuri pe care i le afiseaza clientului </p>
 */
public class ClientCommands {
    public static void main(String[] args) throws IOException {
        String serverAddress = "192.168.0.94"; //IPv4 adress for localhost
        int PORT = 2121;
        System.out.println("Hello! Type in the command you'd like to use!");
        System.out.println("register <name>");
        System.out.println("login <name>");
        System.out.println("friend <name1> <name2> <...> <namek>");
        System.out.println("send <message>");
        System.out.println("read");
        System.out.println("stop");
        System.out.println("exit");
        System.out.println("Your commands: ");
        System.out.println("");

        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            while (!socket.isClosed()) {
                BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = clientInput.readLine();
                String[] tokens = request.split(" ");
                String response;
                if(tokens[0].equals("exit")) {
                    out.println(request); //trimite requestul la server
                    response = serverOutput.readLine(); //primeste raspunsul de la server
                    System.out.println(response); //afiseaza raspunsul
                    socket.close(); //inchide socketul
                } else if(tokens[0].equals("stop")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                    socket.close();
                } else if(tokens[0].equals("login")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else if(tokens[0].equals("register")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else if(tokens[0].equals("friends")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                }

            }

        } catch (UnknownHostException exception) {
            System.err.println("No server listening :'( ... " + exception);
        }
    }
}