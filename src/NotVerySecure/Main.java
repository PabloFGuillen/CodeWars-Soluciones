package NotVerySecure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final Pattern PATTERN = Pattern.compile("^([A-Z]|[a-z]|[0-9]){1,}$");
    public static void main(String args[]) {
        System.out.println(alphanumeric("punctuation"));
    }

    public static boolean alphanumeric(String s){
        boolean isSecure = false;

        if(matchesPatter(s)){
            isSecure = true;
        }

        return isSecure;
    }

    public static boolean matchesPatter(String string){
        Matcher matcher = PATTERN.matcher(string);
        return matcher.matches();
    }
}
