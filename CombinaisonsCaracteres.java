import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

class CombinaisonsCaracteres {
    public static List<String> genererCombinaisons(int longueur) {
        List<String> combinaisons = new ArrayList<>();
        genererCombinaisonsRecursif("", longueur, combinaisons);
        return combinaisons;
    }
    
    private static void genererCombinaisonsRecursif(String combinaisonActuelle, int longueur, List<String> combinaisons) {
        // Condition de sortie de la récursivité : la combinaison a atteint la longueur souhaitée
        if (combinaisonActuelle.length() == longueur) {
            combinaisons.add(combinaisonActuelle) ;
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