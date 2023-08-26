import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FiveMJohnson {
    public static void main(String[] args) throws Exception {
        int m = (int) Math.pow(2, 7);
        char[] cipher = new char[m];
        for (int i = 0; i < m; i++) {
            cipher[i] = (char) mod(((i - 3) * 55), 128);
        }
        String plain = read("src/cipher.txt");
        for (int i = 0; i < plain.length(); i++) {
            System.out.print(cipher[plain.charAt(i)]);
        }
    }

    public static String read(String path) {
        String ret = null;
        try {
            ret = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static int mod(int x, int n) {
        return ((x % n) + n) % n;
    }
}