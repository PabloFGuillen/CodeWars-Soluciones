package ConsonantValue;

import java.util.ArrayList;

public class Main {

    public static final Integer ALPHABET_ASCII_DIFERENCE = 96;

    public enum Vowel {
        a,
        e,
        i,
        o,
        u,
    }
    public static void main(String[] args){
        System.out.println(getConsonantValues("z"));
    }

    public static Integer getConsonantValues(String stringToGetConsonantValues){

        return getHigherConsonantValue(stringToGetConsonantValues);

    }

    public static Integer getHigherConsonantValue(String stringToGetConsonantValues){
        Integer sumOfConsonantValues = 0;
        Integer highestValue = sumOfConsonantValues;
        stringToGetConsonantValues += "a";
        for(int index = 0; index < stringToGetConsonantValues.length(); index++){
            Character charAtPositionX = stringToGetConsonantValues.charAt(index);

            if(isVowel(charAtPositionX)){

                if(highestValue < sumOfConsonantValues){
                    highestValue = sumOfConsonantValues;
                }

                sumOfConsonantValues = 0;


            }

            else{
                sumOfConsonantValues += getCharValue((charAtPositionX));
            }

        }

        return highestValue;
    }


    public static Integer getCharValue(Character character){
        int alphabetPosition = character - ALPHABET_ASCII_DIFERENCE;
        return  alphabetPosition;
    }
    public static boolean isVowel(Character character){
        boolean assertVowel = false;
        for(Vowel vowel: Vowel.values()){
            if(vowel.name().equals(character.toString())){
                assertVowel = true;
                break;
            }
        }

        return assertVowel;
    }


}
