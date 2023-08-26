import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourMJohnson {
    public static void main(String[] args) throws Exception {
        double startTime = System.nanoTime();
        cumulativeSum();
        double duration = System.nanoTime() - startTime;
        duration = duration / (60 * Math.pow(10, 9));
        System.out.println("\nDuration " + duration);
    }

    public static void cumulativeSum() {
        byte[] bytes = getFileBytes("src/half_gaps.bin");
        long[] gaps = new long[bytes.length];
        long sum = 0;

        for (int i = 0; i < gaps.length; i++) {
            gaps[i] = Byte.toUnsignedLong(bytes[i]);
        }

        for (int i = 0; i < gaps.length; i++) {
            // finds the sum
            sum += gaps[i];

            // replaces
            gaps[i] = sum;
        }

        for (int i = 0; i < gaps.length; i++) {
            // multiply sum by 2 and add 3
            gaps[i] = (gaps[i] * 2) + 3;
        }
        // formatting + printing first 15 numbers
        System.out.println();
        System.out.println("First 15 Numbers: ");
        for (int i = 0; i < 15; i++) {
            System.out.print(gaps[i] + ", ");
        }

        // formatting + printing out the 5 largest values
        System.out.println();
        System.out.println("Last five numbers: ");
        int count = Math.max(0, gaps.length - 5); // makes sure index doesn't start at negative
        for (int i = count; i < gaps.length; i++) {
            System.out.print(gaps[i] + ", ");
        }
    }

    public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
