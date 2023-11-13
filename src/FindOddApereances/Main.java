package FindOddApereances;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        int[] a = {1,4,5,5,1,3,4};
        System.out.println(findIt(a));
    }

    public static int findIt(int[] a) {
        Arrays.sort(a);
        Map<Integer, Long> frequencyMap = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Integer result = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        return result;
    }
}
