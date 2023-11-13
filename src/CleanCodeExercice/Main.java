package CleanCodeExercice;

public class Main {
    public static void main(String[] args) {
        String input = "Hello, Code Mess!";
        String processedInput = "";

        processedInput = iterateOverString(input, processedInput);

        System.out.println("Processed input: " + processedInput);
    }

    private static String iterateOverString(String input, String o) {
        for (int i = 0; i < input.length(); i++) {
            if (isNotWhiteSpace(input, i)) {
                o += addCharacterAtX(input, i);
            }
        }
            
        return o;
    }

    private static String addCharacterAtX(String input, int i) {
        return Character.toString(input.charAt(i));
    }

    private static boolean isNotWhiteSpace(String input, int i) {
        return input.charAt(i) != ' ';
    }

    public static int Calculate(int a, int b) {
        int result = 0;

        if (a < 0) {
            result = b - a;
        } else {
            for (int i = 0; i < b; i++) {
                result += a;
            }
        }

        return result;
    }

    public static boolean checkValue(int val) {
        if (valuesIsBetween10And100(val))
        {
            if (isDivisibleBy2(val))
                return true;
        }


        return false;
    }

    private static boolean valuesIsBetween10And100(int val) {
        return val >= 10 && val <= 100;
    }

    private static boolean isDivisibleBy2(int val) {
        return val % 2 == 0;
    }
}
