package RemoveDuplicates;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StripComments {
    public static void main(String[] args){
        stripComments("a\n b\nc", new String[] { "#", "!"});
    }

    public static String stripComments(String text, String[] commentSymbols) {
        text = String.join("\n", Arrays.stream(text.split("\n"))
                .map(n ->  {
                    for(String str: commentSymbols){
                        if(n.contains(str)){
                            n = n.substring(0, n.indexOf(str));
                        }
                    }
                    if(n.contains(" ") && 0 < n.lastIndexOf(" ")){
                        n = n.substring(0, n.lastIndexOf(" "));
                        if(n.matches("^(( )*)$")){
                            n = n.strip();
                        }
                    }
                    return n;
                }).toArray(String[]::new));
        return text;
    }
}
