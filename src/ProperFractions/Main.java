package ProperFractions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/55b7bb74a0256d4467000070/train/java
public class Main {
    public static void main(String[] args){
        properFractions(15);
    }

    public static long properFractions(long n) {
        int total = 0;
        ArrayList<Integer> denominatorList = getDivisorsForGivenNumber(n);
        for(int i = 1; i < n; i++){
            ArrayList<Integer> numeratorList = new ArrayList<>();
            numeratorList = getDivisorsForGivenNumber((int) i);
            numeratorList.retainAll(denominatorList);
            if(numeratorList.size() == 1){
                total++;
            }
        }

        return total;
    }

    private static ArrayList<Integer> getDivisorsForGivenNumber(long n) {
        ArrayList<Integer> integerList = new ArrayList<>();
        int index = 2;
        long  den = n;
        do{
            if(indexIsLowerThan9AndModuleIs0(den, index)){
                integerList.add(index);
                den = den / index;
                index = 2;
            }
            index++;
        } while(moduleIsNot0AndNumberIsNot9(den, index));
        integerList.add(1);
        return integerList;
    }

    private static boolean indexIsLowerThan9AndModuleIs0(long n, int index) {
        return (n % index == 0) && index <= 9;
    }

    private static boolean moduleIsNot0AndNumberIsNot9(long n, int i) {
        return (i != n+1 && i <= 9) && n != 1;
    }
}
