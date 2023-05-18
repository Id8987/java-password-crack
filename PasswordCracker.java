public class PasswordCracker{
    public static void main(String[] args) {
        PasswordCrackerFactory pwdFactory = new PasswordCrackerFactory();
        PasswordInterface fb = pwdFactory.decryptPassword("bruteforce");
        //fb.findClearPassword("abc");
        PasswordInterface dic = pwdFactory.decryptPassword("");
        dic.findClearPassword("soxnaAnta");
    }
}