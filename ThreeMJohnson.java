import java.util.Scanner;

public class ThreeMJohnson {
    public static void main(String[] args) throws Exception {
        // Open scanner for input
        Scanner scan = new Scanner(System.in);
        int input = 0;

        // User welcome
        System.out.println("Welcome to Eratosthenes generator!");
        System.out.println("Input a number:");
        input = scan.nextInt();

        // Part 2
        double startTime = System.nanoTime();
        eratosthenes(input);
        double duration = System.nanoTime() - startTime;
        duration = duration / (60 * Math.pow(10, 9));
        System.out.println("\nDuration " + duration);

        // Part 3

        // Close scanner
        scan.close();
    }

    public static void eratosthenes(int n) {
        // starts at n+1, so the array includes all numbers between 0-n
        boolean eraArray[] = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            eraArray[i] = true;
        }

        // starts at index of 2, since 0 and 1 are not prime
        // sets index values greater than 2 to true
        for (int i = 2; i * i <= n; i++) {
            // if there's a multiple of j, it is set to false
            // meaning, they are not prime
            for (int j = i * i; j <= n; j += i) {
                eraArray[j] = false;
            }
        }

        // formatting + printing out the values
        // only if the array value is a prime number
        for (int i = 2; i <= n; i++) {
            if (eraArray[i] == true) {
                System.out.print(i + ", ");
            }
        }

        // formatting + printing out the 5 largest values
        System.out.println();
        System.out.println("Five largest numbers: ");
        int count = 0;
        for (int i = eraArray.length - 1; i >= 2; i--) {
            if (eraArray[i]) {
                System.out.print(i + ", ");
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
    }
}
