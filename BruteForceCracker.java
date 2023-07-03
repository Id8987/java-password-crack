import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class BruteForceCracker implements PasswordInterface {
    public static void main(String[] args) {
        BruteForceCracker bf = new BruteForceCracker() ;
        bf.findPassword("zzs");
    }
    public void findPassword(String mot){
        if(Md5.estHacheMD5(mot)){
            findHashedPassword(mot);
            System.out.println("la methode du  hash appele");
        }else{
            findClearPassword(mot);
        }
    }
    @Override
    public  String findHashedPassword(String passwordAdeviner) {
        List<String> combinaisons = CombinaisonsCaracteres.genererCombinaisons(4); // Spécifiez la longueur souhaitée ici
        String motCible = passwordAdeviner; //"900150983cd24fb0d6963f7d28e17f72"; // Le mot cible haché avec MD5
        String findedPassword = "";
        boolean correspondanceTrouvee = false;
        long tempsDebut = System.currentTimeMillis();
        
        // Parcourir toutes les combinaisons générées
        for (String combinaison : combinaisons) {
            String hashCombinaison = getMD5Hash(combinaison);
            
            System.out.println("Comparaison avec : " + combinaison + ", Hash MD5 : " + hashCombinaison);
            
            if ( hashCombinaison.equals(motCible)) {
                correspondanceTrouvee = true;
                findedPassword = combinaison;
                break;
            }
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
    public String findClearPassword( String passwordADeviner) {
        List<String> combinaisons = CombinaisonsCaracteres.genererCombinaisons(4); // Spécifiez la longueur souhaitée ici
        String motCible = passwordADeviner; // Le mot à rechercher
        
        boolean correspondanceTrouvee = false;
        long debut = System.currentTimeMillis();
        
        // Parcourir toutes les combinaisons générées et comparer avec le mot cible
        for (String combinaison : combinaisons) {
            System.out.println("Comparaison avec : " + combinaison);
            if (combinaison.equals(motCible)) {
                correspondanceTrouvee = true;
                break;
            }
        }
        
        long fin = System.currentTimeMillis();
        
        // Afficher le résultat
        if (correspondanceTrouvee) {
            System.out.println("Correspondance trouvée !");
        } else {
            System.out.println("Correspondance non trouvée.");
        }
        
        long tempsMis = fin - debut;
        System.out.println("Temps mis : " + tempsMis + " millisecondes");
        return "";
    }
    private static String getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
