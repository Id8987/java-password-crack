import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComparaisonDictionnaire {
    public static void main(String[] args) {
        String fichierDictionnaire = "dictionnaire.csv"; // Chemin du fichier CSV du dictionnaire
        String motCible = "password123"; // Mot de passe cible
        
        boolean correspondanceTrouvee = false;
        long tempsDebut = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(fichierDictionnaire))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String mot = ligne.trim();
                System.out.println("Comparaison avec : " + mot);
                
                if (mot.equals(motCible)) {
                    correspondanceTrouvee = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long tempsFin = System.currentTimeMillis();
        long tempsExecution = tempsFin - tempsDebut;
        
        // Afficher le résultat
        if (correspondanceTrouvee) {
            System.out.println("Correspondance trouvée !");
        } else {
            System.out.println("Correspondance non trouvée.");
        }

        System.out.println("Temps d'exécution : " + tempsExecution + " millisecondes.");
    }
}
