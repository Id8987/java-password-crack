import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionnaryCracker implements PasswordInterface {
    public static void main(String[] args) {
        DictionnaryCracker dc = new DictionnaryCracker();
        dc.findPassword("c46dcb630d64a45465629366fff78d7c");
    }

    public void findPassword(String mot){
        if(estHacheMD5(mot)){
            findHashedPassword(mot);
        }else{
            findClearPassword(mot);
        }
    }
    @Override
    public String findClearPassword(String passwordADeviner) {
        String fichierDictionnaire = "1000000-password-seclists.txt"; // Chemin du fichier CSV du dictionnaire :
                                                                      // dictionnaire.csv
        String motCible = passwordADeviner; // Mot de passe cible
        String findedPassword = "";

        boolean correspondanceTrouvee = false;
        long tempsDebut = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(fichierDictionnaire))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String mot = ligne.trim();
                System.out.println("Comparaison avec : " + mot);

                if (mot.equals(motCible)) {
                    correspondanceTrouvee = true;
                    findedPassword = mot;
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

        return findedPassword;

    }

    @Override
    public String findHashedPassword(String passwordAdeviner) {
        String fichierDictionnaire = "1000000-password-seclists.txt";
        String motCible = passwordAdeviner;

        try (BufferedReader br = new BufferedReader(new FileReader(fichierDictionnaire))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String mot = ligne.trim();
                String hashMot = Md5.getMD5Hash(mot);

                System.out.println("Comparaison avec : " + mot + ", Hash MD5 : " + hashMot);

                if (hashMot.equals(motCible)) {
                    return hashMot;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    private static boolean estHacheMD5(String mot) {
        return mot.length() == 32;
    }

}
