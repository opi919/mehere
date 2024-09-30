import java.io.File;
import java.util.*;

public class TransposeCipher {
    public static String transposeCipher(String text, int width) {
        String str = "";
        int col = 0, i = 0;
        while (col < width) {
            str += text.charAt(i);
            i += width;
            if (i >= text.length())
                i = ++col;
        }
        return str;
    }

    public static String decrypt(String text, int width) {
        char[] str = new char[text.length()];
        Arrays.fill(str, ' '); // fill the text length size with space
        int col = 0, j = 0;
        for (int i = 0; i < text.length(); i++) {
            str[j] = text.charAt(i);
            j += width;
            if (j >= text.length())
                j = ++col;
        }
        return new String(str); //convert char array into string

    }

    public static void main(String[] args) throws Exception {
        String name;// = "losser is trying hard, HE BELIEVES IN ONE AND ONLY ALLAH";
        // String input = Files.readString(Paths.get("caesar.txt"));
        File f = new File("transpose.txt");
        Scanner sc = new Scanner(f);
        name = sc.nextLine();
        sc.close();
        int width = 4;
        String enc = transposeCipher(name, width);
        String enc2 = transposeCipher(enc, 2 * width); //double transpose cipher
        System.out.println(enc);
        System.out.println(enc2);
        String dec = decrypt(enc2, 2 * width);
        String dec2 = decrypt(dec, width);
        System.out.println(dec2);
    }
}
