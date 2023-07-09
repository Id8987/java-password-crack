import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Connected to the server.");

            // entrees utilisateur
            Scanner scanner = new Scanner(System.in);
           
            System.out.println("Entrer le hash");
            String hash = scanner.nextLine();

            System.out.println("Veuillez choisir une methode pour le hack");
            System.out.println("1 pour brute-force");
            System.out.println("2 pour dictionnaire");
            int methodChoice = scanner.nextInt();
           

            

            // envoie le choix de la methode au server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println(hash);
            out.println(methodChoice);

            // recevoir la reponse du serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String result = in.readLine();
            System.out.println("Result: " + result);

            // fermer les connections
            scanner.close();
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
