package Snail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{}};
        System.out.println(snail(array));
    }

    public static int[] snail(int[][] array) {
        int indice = 0;
        int iteracion = 0;
        boolean inverso = false;
        int total = array.length*array.length;
        int[] list = null;
        if(arrayIsNotNull(array) && arrayLengthIsZero(array)){
            list = new int[total];
            if(array[0].length != 0){

                while(indexIsLowerThanTotalItems(indice, total)){

                    if(iterationIsEven(iteracion)){

                        if(isNotInvertedCase(inverso)){

                            for(int i = 0; i < array.length; i++){
                                list[indice] = array[0][i];
                                indice++;
                            }
                            array = Arrays.copyOfRange(array, 1, array.length);
                            iteracion++;

                        }else{

                            for(int i = array.length-1; i >= 0; i--){
                                list[indice] = array[array.length-1][i];
                                indice++;
                            }
                            iteracion++;
                            array = Arrays.copyOfRange(array, 0, array.length-1);
                        }
                    } else{
                        if(isNotInvertedCase(inverso)){
                            for(int i = 0; i < array.length; i++){
                                list[indice] = array[i][array.length];
                                indice++;
                            }


                            array = Arrays.stream(array).map(arr -> Arrays.copyOfRange(arr, 0, arr.length-1)).toArray(int[][]::new);
                            iteracion++;
                            inverso = true;
                        }else{

                            for(int i = array.length-1; i >= 0; i--){
                                list[indice] = array[i][0];
                                indice++;
                            }


                            array = Arrays.stream(array).map(arr -> Arrays.copyOfRange(arr, 1, arr.length)).toArray(int[][]::new);
                            iteracion++;
                            inverso = false;
                        }
                    }
                }
            }
            else{
                int[] a = {};
                list = a;
            }
        }
        return list;
    }

    private static boolean arrayLengthIsZero(int[][] array) {
        return array.length != 0;
    }

    private static boolean isNotInvertedCase(boolean inverso) {
        return inverso == false;
    }

    private static boolean iterationIsEven(int iteracion) {
        return iteracion % 2 == 0;
    }

    private static boolean indexIsLowerThanTotalItems(int indice, int total) {
        return indice < total;
    }

    private static boolean arrayIsNotNull(int[][] array) {
        return array != null;
    }

}
