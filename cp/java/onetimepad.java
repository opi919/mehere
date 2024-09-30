import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class onetimepad {

    public static String cipherText(String str, String key) {
        String cipher = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) { //using the formula
                ch = (char) ((ch - 'A' + key.charAt(i) - 'A') % 26 + 'A');
            } else if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + key.charAt(i) - 'A') % 26 + 'a');
            }
            cipher+=ch;
        }

        return cipher;
    }

    public static String decipherText(String str, String key) {
        String decipher ="";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' - key.charAt(i) + 'A' + 26) % 26 + 'A');
            } else if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' - key.charAt(i) + 'A' + 26) % 26 + 'a');
            }
            decipher+=ch;
        }

        return decipher;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("onetimepad.txt"));
        String text = "DEPARTMENT OF COMPUTER SCIENCE AND ENGINEERING";
        String key = input.nextLine();
       

        String cipher = cipherText(text, key);
        String decipher = decipherText(cipher, key);

        System.out.println("Plain-Text: " + text);
        System.out.println("Cipher-Text: " + cipher);
        System.out.println("Decipher-Text: " + decipher);
    }
}
