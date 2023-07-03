public class PasswordCrackerFactory {
    public PasswordInterface decryptPassword (String methode){
        if(methode.equals("bruteforce")){
            return new BruteForceCracker();
        }else{
            return new DictionnaryCracker() ;
        }
    }
}
