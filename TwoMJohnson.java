import java.util.Scanner;

public class TwoMJohnson {
    public static void main(String args[]) {
        // Open scanner for input
        Scanner scan = new Scanner(System.in);
        int input = 0;

        // User welcome 
        System.out.println("Welcome to Fibonacci generator!");
        System.out.println("Input a number:");

        // Try to accept the input
        try {
            input = scan.nextInt();
            fibonacci(input);
        } catch (Exception e){ // Catch any input error
            System.out.println("Error! You must enter a number of 1 or higher.");
        }
        // Close scanner
        scan.close();
    }

    public static void fibonacci(int n) {
        // First number, Second number
        int number1 = 0;
        int number2 = 1;
        int fibb[] = new int[n];
        int count = 0;

        // While the count is less than the given number
        while (count < n) {
            fibb[count] = number1;
            int number3 = number1 + number2;
            number1 = number2;
            number2 = number3;
            count += 1;
        }
        // formatting
        int digits = ((int)Math.log10(fibb[fibb.length - 1])) + 1;
        digits +=2;
        for(int i = 0; i < fibb.length; i++) {
            if(i % 7 == 0 && i > 0) {
                System.out.println();
            }
            System.out.printf("%" + digits + "d", fibb[i]);
        }
    }
}