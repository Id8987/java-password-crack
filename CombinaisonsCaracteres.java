import java.util.ArrayList;
import java.util.List;

public class CombinaisonsCaracteres {
    public static void main(String[] args) {
        List<String> combinaisons = genererCombinaisons(3); // Spécifiez la longueur souhaitée ici
        String motCible = "abc"; // Le mot à rechercher
        
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
    }
    
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
