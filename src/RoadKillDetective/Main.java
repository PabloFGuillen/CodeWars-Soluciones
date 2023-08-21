package RoadKillDetective;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    private static final ArrayList<String> ANIMALS = Arrays.asList(Preloaded.ANIMALS);
    public static void main (String[] args){
        System.out.println(roadKill("==========h===yyyyyy===eeee=n==a========"));
    }

    private static String roadKill(final String photo){
        return scanPhoto(photo);

    }

    private static String scanPhoto(String photo){
        photo = cleanRoad(photo);
        return photo;
    }

    private static String cleanRoad(String photo){
        photo = photo.replace("=", "");
        photo = getAnimalInPhoto(photo);
        return photo;
    }

    private static String getAnimalInPhoto(String photo){

        return animalInPhoto(photo);
    }

    private static String animalInPhoto(String photo){
        photo = searchAnimalInPhoto(photo);
        return photo;
    }

    private static String searchAnimalInPhoto(String photo){
        int index = iterateOverAnimalList(photo);


        if(index != -1){
            photo = ANIMALS.get(index);
        }

        else{
            photo = "??";
        }


        return photo;
    }

    private static int iterateOverAnimalList(String photo){
        int index = 0;
        boolean animalHasBeenRecognised = false;
        while(animalHasntBeenRecognised(index, animalHasBeenRecognised)){
            animalHasBeenRecognised = isAnimalInAnimalList(index, photo);
            index++;
        }

        if(animalHasBeenRecognised){
            return index;
        }

        else{
            index = -1;
            return index;
        }
    }
    private static boolean animalHasntBeenRecognised(int index, boolean findAnimal) {
        return index < ANIMALS.size() && findAnimal == false;
    }

    private static boolean isAnimalInAnimalList(int index, String photo){
        String regExr = createFinalRegularExpresion(index);
        boolean foundAnimal = isAnimalFound(photo, regExr);

        return foundAnimal;
    }

    private static boolean isAnimalFound(String photo, String regExr) {
        boolean foundAnimal = false;

        Pattern pattern = Pattern.compile(regExr);
        if(isMatchesPattern(photo, pattern)){
            foundAnimal = true;
        }
        return foundAnimal;
    }

    private static String createFinalRegularExpresion(int index) {
        return "^" + createRegExt(index) + "$";
    }

    private static boolean isMatchesPattern(String photo, Pattern pattern) {
        return pattern.matcher(photo).matches();
    }

    private static String createRegExt(int index){

        String animal = ANIMALS.get(index);
        String regExr = generateRegExr(animal);

        return regExr;
    }
    private static String generateRegExr(String animal){
        String regExr = firstPartRegExr(animal) + "|" + secondPartRegExr(animal);
        
        return regExr;
    }

    private static String firstPartRegExr(String animal) {
        String regExr = "";
        for(int j = 0; j < animal.length(); j++){
            String charAtX = Character.toString(animal.charAt(j));
            regExr += charAtX + "{1,}";
        }
        return regExr;
    }

    private static String secondPartRegExr(String animal){
        String regExr = "";
        for(int j = animal.length()-1; j >= 0; j--){
            String charAtX = Character.toString(animal.charAt(j));
            regExr += charAtX + "{1,}";
        }
        return regExr;
    }
}
