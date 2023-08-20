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
        boolean findAnimal = false;
        int index = 0;
        while(index < ANIMALS.size() && findAnimal == false){
            String regExr = "^" + createRegExt(index) + "$";
            System.out.println(regExr);

            Pattern pattern = Pattern.compile(regExr);
            if(isMatches(photo, pattern)){
                findAnimal = true;
                photo = ANIMALS.get(index);
            }

            index++;
        }



        if(findAnimal == false){
            photo = "??";
        }
        return photo;
    }

    private static boolean isMatches(String photo, Pattern pattern) {
        return pattern.matcher(photo).matches();
    }

    private static String createRegExt(int index){

        String animal = ANIMALS.get(index);
        String regExr = generateRegExr(animal);

        return regExr;
    }
    private static String generateRegExr(String animal){
        String regExr = "";
        for(int j = 0; j < animal.length(); j++){
            String charAtX = Character.toString(animal.charAt(j));
            regExr += charAtX + "{1,}";
        }

        regExr += "|";
        for(int j = animal.length()-1; j >= 0; j--){
            String charAtX = Character.toString(animal.charAt(j));
            regExr += charAtX + "{1,}";
        }




        return regExr;
    }
}
