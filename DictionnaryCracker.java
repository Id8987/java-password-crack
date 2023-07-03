import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DictionnaryCracker implements PasswordInterface {
    public static void main(String[] args) {
        DictionnaryCracker dc = new DictionnaryCracker();
        dc.findPassword("c46dcb630d64a45465629366fff78d7c");
    }
    
    public void findPassword(String mot) {
        if (estHacheMD5(mot)) {
            findHashedPassword(mot);
        } else {
            findClearPassword(mot);
        }
    }

    // @Override
    // public String findClearPassword(String passwordADeviner) {
    //     String fichierDictionnaire = "1000000-password-seclists.txt"; // Chemin du fichier CSV du dictionnaire :
    //                                                                   // dictionnaire.csv
    //     String motCible = passwordADeviner; // Mot de passe cible
    //     String Password = "";

    //     boolean correspondanceTrouvee = false;
    //     long tempsDebut = System.currentTimeMillis();

    //     try (BufferedReader br = new BufferedReader(new FileReader(fichierDictionnaire))) {
    //         String ligne;
    //         while ((ligne = br.readLine()) != null) {
    //             String mot = ligne.trim();
    //             System.out.println("Comparaison avec : " + mot);

    //             if (mot.equals(motCible)) {
    //                 correspondanceTrouvee = true;
    //                 Password = mot;
    //                 break;
    //             }
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     long tempsFin = System.currentTimeMillis();
    //     long tempsExecution = tempsFin - tempsDebut;

    //     // Afficher le résultat
    //     if (correspondanceTrouvee) {
    //         System.out.println("Correspondance trouvée !");
    //     } else {
    //         System.out.println("Correspondance non trouvée.");
    //     }

    //     System.out.println("Temps d'exécution : " + tempsExecution + " millisecondes.");

    //     return Password;

    // }
    @Override
    public String findClearPassword(String passwordADeviner) {
        String motCible = passwordADeviner; // Mot de passe cible
        String password = "";
        try {
            File dictionnaire = new File("1000000-password-seclists.txt");
            Scanner reader = new Scanner(dictionnaire);
            while(reader.hasNextLine()){
                String testedWith = reader.nextLine();
                System.out.println("Comparaison avec : " + testedWith);
                if(motCible.equals(testedWith)){
                    password = testedWith;
                    System.out.println("----------Trouve--------");
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return password;
    }

    // @Override
    // public String findHashedPassword(String passwordAdeviner) {
    //     String fichierDictionnaire = "1000000-password-seclists.txt";
    //     String motCible = passwordAdeviner;

    //     try (BufferedReader br = new BufferedReader(new FileReader(fichierDictionnaire))) {
    //         String ligne;
    //         while ((ligne = br.readLine()) != null) {
    //             String mot = ligne.trim();
    //             String hashMot = Md5.getMD5Hash(mot);

    //             System.out.println("Comparaison avec : " + mot + ", Hash MD5 : " + hashMot);

    //             if (hashMot.equals(motCible)) {
    //                 return hashMot;
    //             }
    //         }

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }

    //     return null;
    // }
    @Override
    public String findHashedPassword(String motDePasseADeviner){
        String password = null;
        try {
            File dictionnaire = new File("1000000-password-seclists.txt");
            Scanner reader = new Scanner(dictionnaire);
            while(reader.hasNextLine()){
                String testedWith = reader.nextLine() ;
                System.out.println("Comparaison avec : " + testedWith + ", Hash MD5 : " + Md5.getMD5Hash(testedWith));
                if(motDePasseADeviner.equals(Md5.getMD5Hash(testedWith))){
                    password = testedWith;
                    break;
                }
            }

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return password;
    }

    private static boolean estHacheMD5(String mot) {
        return mot.length() == 32;
    }

}
