import java.util.Scanner;

public class PasswordCracker{
    public static void main(String[] args) {
        //******** */ la fonction de cette classe est remplacee par le server: PasswordCrackerServer
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******Bienvenu dans notre cracker de mot de passe ******");
        System.out.println("Veuillez entrez un mot de passe");
        String mot = scanner.nextLine();

        System.out.println("Veuillez choisir une methode:");
        System.out.println("1: Pour la methode dictionnaire");
        System.out.println("2: pour la methode brute force");
        int choice = scanner.nextInt();

        scanner.close();
        if(choice == 2){
            PasswordCrackerFactory pwdFactory = new PasswordCrackerFactory();
            PasswordInterface fb = pwdFactory.decryptPassword("bruteforce");
            fb.findClearPassword(mot);
        }else if(choice ==1){
            PasswordCrackerFactory pwdFactory = new PasswordCrackerFactory();
            PasswordInterface dic = pwdFactory.decryptPassword("dictionnaire");
            dic.findClearPassword(mot);
        }else{
            System.out.println("Choix non disponible");
        }
        

    }
}