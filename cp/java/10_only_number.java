import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    
    // Function to calculate gcd
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        }
        return gcd(b, a.mod(b));
    }

    // Function for modular exponentiation (base^exp % mod)
    public static BigInteger modPow(BigInteger base, BigInteger exp, BigInteger mod) {
        BigInteger result = BigInteger.ONE;
        while (exp.compareTo(BigInteger.ZERO) > 0) {
            if (exp.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = result.multiply(base).mod(mod);
            }
            base = base.multiply(base).mod(mod);
            exp = exp.divide(BigInteger.TWO);
        }
        return result;
    }

    // Function to find modular inverse using Extended Euclidean Algorithm
    public static BigInteger modInverse(BigInteger e, BigInteger phi) {
        BigInteger[] result = extendedGCD(e, phi);
        BigInteger t = result[1]; // t is the modular inverse
        if (t.compareTo(BigInteger.ZERO) < 0) {
            t = t.add(phi);
        }
        return t;
    }

    // Extended Euclidean Algorithm
    public static BigInteger[] extendedGCD(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[] { a, BigInteger.ONE, BigInteger.ZERO };
        }
        BigInteger[] result = extendedGCD(b, a.mod(b));
        BigInteger gcd = result[0];
        BigInteger x = result[2];
        BigInteger y = result[1].subtract(a.divide(b).multiply(result[2]));
        return new BigInteger[] { gcd, x, y };
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        PrintWriter output = new PrintWriter(new File("output.txt"));

        // Read primes p and q from file
        BigInteger p = input.nextBigInteger();
        BigInteger q = input.nextBigInteger();
        
        // Calculate n = p * q and phi = (p-1)*(q-1)
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Choose e such that 1 < e < phi and gcd(e, phi) = 1
        BigInteger e = BigInteger.TWO;
        while (!gcd(e, phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }

        // Calculate d (private key) such that (d * e) % phi = 1
        BigInteger d = modInverse(e, phi);

        // Read plaintext from file
        BigInteger plaintext = input.nextBigInteger();

        // Encrypt: ciphertext = (plaintext^e) % n
        BigInteger ciphertext = modPow(plaintext, e, n);
        output.println("Ciphertext: " + ciphertext);

        // Decrypt: decrypted = (ciphertext^d) % n
        BigInteger decrypted = modPow(ciphertext, d, n);
        output.println("Decrypted text: " + decrypted);

        input.close();
        output.close();
    }
}
