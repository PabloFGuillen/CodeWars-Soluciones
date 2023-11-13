package StripSimbles;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main (String[] args){
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples",new String[] {"#", "!"}));
    }

    public static String stripComments(String text, String[] commentSymbols) {
        Stream<String> stream = Stream.of(text);
        return null;
    }
}
