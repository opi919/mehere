import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class Caesar {
    public static String encrypt(String data,int key,int modulo){
        String enc="";
        for(int i=0;i<data.length();i++){
            char ch = data.charAt(i);
            if(ch>='a' && ch<='z'){
                ch = (char)('a'+(ch-'a'+key)%modulo);// return int value so we need casting
            
            }
            else if(ch>='A' && ch<='Z'){
                ch = (char)('A'+(ch-'A'+key)%modulo);
            }
            enc += ch;
        }
        return enc;
    }
    public static void main(String[] args) throws Exception{
        // read from text file
        File file = new File("caesar.txt");
        Scanner sc = new Scanner(file);
        
        String input,tem;
        input = "";
        
        while(sc.hasNextLine()){
            tem = sc.nextLine();
            input = input + " " +tem;
            break;
        }

        // input = Files.readString(Paths.get("caesar.txt"));

        System.out.println(input);
        int n=sc.nextInt();
        System.out.println(n);
        String encrypted = encrypt(input,n,26);
        String decrypted = encrypt(encrypted,26-n,26);
        System.out.println("Encrypted: "+encrypted);
        System.out.println("Decrypted: "+decrypted);
    }
}
