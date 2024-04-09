package PigLatin;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatin {

    public static void main(String[] args){
        pigIt("Pig latin is cool");
    }
    public static String pigIt(String str) {

        List<String> strings =   Arrays.stream(str.split(" "))
                .map(n -> {
                    if(n.matches("([a-zA-Z])+")){
                        return n.concat(Character.toString(n.charAt(0))).replaceFirst(Character.toString(n.charAt(0)), "").concat("ay");
                    }
                    else{
                        return n;
                    }
                })
                .collect(Collectors.toList());

        str = "";
        for(int i = 0; i < strings.size()-1; i++){
            str = str.concat(strings.get(i));
            if(i != strings.size()-1){
                str = str.concat(" ");
            }

        }
        System.out.println(str);
        return str;
    }
}
