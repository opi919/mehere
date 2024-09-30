import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Polygon {
    static Map<String, String> encoder = new HashMap<>();
    static Map<String, String> decoder = new HashMap<>();

    static void createDictionary() throws FileNotFoundException {
        File file = new File("dictionary.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String s1 = input.next();
            String s2 = input.next();
            encoder.put(s1, s2);
            decoder.put(s2, s1);
        }
       
    }

    static String cipherText(String str) {
        String cipher = "", temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                temp += str.charAt(i);
                if (encoder.containsKey(temp)) {
                    cipher += encoder.get(temp);
                    temp = "";
                }
            } else {
                cipher += str.charAt(i);
            }
        }

        return cipher;
    }

    static String decipherText(String str) {
        String decipher = "", temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                temp += str.charAt(i);
                if (decoder.containsKey(temp)) {
                    decipher += decoder.get(temp);
                    temp = "";
                }
            } else {
                decipher += str.charAt(i);
            }
        }

        return decipher;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("polygon.txt");
        Scanner input = new Scanner(file);
        String str = input.nextLine();
        input.close();

        createDictionary();

        String cipher = cipherText(str);
        String decipher = decipherText(cipher);

        System.out.println("Plain-Text: " + str);
        System.out.println("Cipher-Text: " + cipher);
        System.out.println("Decipher-Text: " + decipher);
    }
}
