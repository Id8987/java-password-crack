import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ComparaisonHashMD5 {
    public static void main(String[] args) {
        List<String> combinaisons = CombinaisonsCaracteres.genererCombinaisons(3); // Spécifiez la longueur souhaitée ici
        String motCible = "900150983cd24fb0d6963f7d28e17f72"; // Le mot cible haché avec MD5
        
        boolean correspondanceTrouvee = false;
        long tempsDebut = System.currentTimeMillis();
        
        // Parcourir toutes les combinaisons générées
        for (String combinaison : combinaisons) {
            String hashCombinaison = getMD5Hash(combinaison);
            
            System.out.println("Comparaison avec : " + combinaison + ", Hash MD5 : " + hashCombinaison);
            
            if (hashCombinaison.equals(motCible)) {
                correspondanceTrouvee = true;
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

class CombinaisonsCaracteres {
    public static List<String> genererCombinaisons(int longueur) {
        List<String> combinaisons = new ArrayList<>();
        genererCombinaisonsRecursif("", longueur, combinaisons);
        return combinaisons;
    }
    
    private static void genererCombinaisonsRecursif(String combinaisonActuelle, int longueur, List<String> combinaisons) {
        // Condition de sortie de la récursivité : la combinaison a atteint la longueur souhaitée
        if (combinaisonActuelle.length() == longueur) {
            combinaisons.add(combinaisonActuelle);
            return;
        }
        
        // Ajouter tous les chiffres
        for (int i = 0; i <= 9; i++) {
            genererCombinaisonsRecursif(combinaisonActuelle + i, longueur, combinaisons);
        }
        
        // Ajouter toutes les lettres minuscules
        for (char c = 'a'; c <= 'z'; c++) {
            genererCombinaisonsRecursif(combinaisonActuelle + c, longueur, combinaisons);
        }
    }
}
