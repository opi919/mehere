#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
using namespace std;

// Function to calculate GCD
int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
}

// Function to calculate (base^exp) % mod
long long modPow(long long base, long long exp, long long mod) {
    long long result = 1;
    while (exp > 0) {
        if (exp % 2 == 1)
            result = (result * base) % mod;
        base = (base * base) % mod;
        exp /= 2;
    }
    return result;
}

// Function to find modular inverse using Extended Euclidean Algorithm
long long modInverse(long long e, long long phi) {
    long long t = 0, newt = 1;
    long long r = phi, newr = e;
    while (newr != 0) {
        long long quotient = r / newr;
        t = t - quotient * newt;
        swap(t, newt);
        r = r - quotient * newr;
        swap(r, newr);
    }
    if (t < 0) t += phi;
    return t;
}

int main() {
    ifstream infile("10.txt");
    ofstream outfile("output10.txt");

    // Prime numbers (you should use larger primes in real RSA)
    long long p, q;
    infile >> p >> q;
    
    // Calculate n = p * q and phi = (p-1)*(q-1)
    long long n = p * q;
    long long phi = (p - 1) * (q - 1);

    // Choose e such that 1 < e < phi and gcd(e, phi) = 1
    long long e;
    for (e = 2; e < phi; e++) {
        if (gcd(e, phi) == 1)
            break;
    }

    // Calculate d (private key) such that (d * e) % phi = 1
    long long d = modInverse(e, phi);

    // Read plaintext from file
    long long plaintext;
    infile >> plaintext;

    // Encrypt: ciphertext = (plaintext^e) % n
    long long ciphertext = modPow(plaintext, e, n);
    outfile << "Ciphertext: " << ciphertext << endl;

    // Decrypt: decrypted = (ciphertext^d) % n
    long long decrypted = modPow(ciphertext, d, n);
    outfile << "Decrypted text: " << decrypted << endl;

    infile.close();
    outfile.close();
    return 0;
}
