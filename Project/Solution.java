import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        
        int max = Integer.MIN_VALUE;
        while (scan.hasNextInt()) {
            int x = scan.nextInt();
            if (x % 2 == 0 && x > max) {
                max = x;
            }
            System.out.println(max);
        }

    }
}