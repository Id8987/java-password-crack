import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String serverPassword = "pass";

            
            String choice = reader.readLine();       

            // // Utiliser la méthode de crack de mot de passe appropriée en fonction du choix du client
            PasswordCrackerFactory pwdFactory = new PasswordCrackerFactory();

            if(choice.equals("1")){
                PasswordInterface bruteForceCracker = pwdFactory.decryptPassword("bruteforce");
                String bruteForceResult = bruteForceCracker.findClearPassword(serverPassword);
                writer.println("Brute Force Result: " + bruteForceResult);

            }else if(choice.equals("2")){
                PasswordInterface dictionaryCracker = pwdFactory.decryptPassword("");
                String dictionaryResult = dictionaryCracker.findClearPassword(serverPassword);
                writer.println("Dictionary Result: " + dictionaryResult);
                
            }else{
                System.out.println("choix indisponible");
            }
            
            // Fermer les flux et la connexion client
            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

