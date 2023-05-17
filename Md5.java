import java.security.MessageDigest;

public class Md5 {
    public static void main(String[] A) throws Exception {
        // mot de passe a Hacher :
        String password = "abc"; //

        // appel de la fonction de hachage
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        // convertir le tableau de bits en une format hexadécimal - méthode 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("En format hexa : " + sb.toString());

        String passwords[] = {"hello", "passer", "azerty", };
    }
}