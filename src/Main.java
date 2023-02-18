import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static boolean isRoman = false;
    static Map<Character, Integer> numbersMap = new HashMap() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
    }};

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);

    }


    public static String calc(String input) throws Exception {
        int result = 0;
        String[] array = input.split("[ ]");
        if(array.length > 3){
            throw new Exception("Error");
        }
        Object[] res1 = toNumber(array[0]);
        String operator = array[1];
        Object[] res2 = toNumber(array[2]);

        if (res1[1] != res2[1]) {
            throw new Exception("Error");
        }else if((Boolean) res1[1] && (Boolean) res2[1]){
            isRoman = true;
        }
        int num1 = (Integer) res1[0];
        int num2 = (Integer) res2[0];


        if(num1 > 10 || num2 > 10 || num1 < 0 || num2 < 0){
            throw new Exception("Error");
        }
        switch (operator) {
            case "+": {
                result = sum(num1, num2);
                break;
            }
            case "-": {
                result = subtraction(num1, num2);
                break;
            }
            case "*": {
                result = multiplication(num1, num2);
                break;
            }
            case "/": {
                result = division(num1, num2);
                break;
            }
            default: {
                throw new Exception("Exception message");
            }

        }
        String stringResult = "";
        if (isRoman) {
             stringResult = arabicToRoman(result);
        } else {

             stringResult = Integer.toString(result);
        }
        return stringResult;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static Object[] toNumber(String input) {
        try {
            int intValue = Integer.parseInt(input);
            return new Object[]{intValue, false};
        } catch (NumberFormatException e) {
            int result = 0;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (i > 0 && numbersMap.get(ch) > numbersMap.get(input.charAt(i - 1))) {
                    result += numbersMap.get(ch) - 2 * numbersMap.get(input.charAt(i - 1));
                } else
                    result += numbersMap.get(ch);
            }
            return new Object[]{result, true};
        }
    }
    public static String arabicToRoman(final int number) {
        if (number < 0 || 4000 <= number) {
            throw new IllegalArgumentException();
        }
        String[] nums = { "I", "V", "X", "L", "C", "D", "M" };
        int numCounter = 0;
        String result = "";
        StringBuilder partResult = new StringBuilder();
        int numeral;
        String stringNumber = String.valueOf(number);
        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            partResult.delete(0, partResult.length());
            numeral = Integer.parseInt(stringNumber.substring(i, i + 1));
            if (1 <= numeral && numeral < 4) {
                for (int j = 0; j < numeral; j++) {
                    partResult.append(nums[numCounter]);
                }
                numCounter += 2;
            } else if (4 <= numeral && numeral < 9) {
                numCounter += 2;
                if (numeral == 4) {
                    partResult.append(nums[numCounter - 2]);
                }
                partResult.append(nums[numCounter - 1]);
                for (int j = 0; j < (numeral - 5); j++) {
                    partResult.append(nums[numCounter - 2]);
                }
            } else if (numeral == 9) {
                numCounter += 2;
                partResult.append(nums[numCounter - 2] + nums[numCounter]);
            } else if (numeral == 0) {
                numCounter += 2;
            }
            result = partResult.append(result).toString();
        }
        return result;
    }
}
/*
найти первое число в строке
найти второе число в строке
возможно .split("[+-/*\"]");
найти знак + - * /

сделать проверку на ввод 2 чисел
сделать проверку на ввод + - * /
отдельный класс для римских чисел и массив с римскими числами
 */