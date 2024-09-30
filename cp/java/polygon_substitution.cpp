#include <bits/stdc++.h>
using namespace std;

map <string, string> encoder, decoder;

void createDictionary() {
    freopen("dictionary.txt", "r", stdin);
    string s1, s2;
    while (cin >> s1 >> s2) {
        encoder[s1] = s2;
        decoder[s2] = s1;
    }

}

string cipherText(string str) {
    string cipher = "", temp = "";

    for (int i = 0; i < str.size(); i++) {
        if (isalpha(str[i])) {
            temp += str[i];

            if (encoder.find(temp) != encoder.end()) {
                cipher += encoder[temp];
                temp = "";
            }
        }
        else {
            cipher += str[i];
        }
    }

    return cipher;
}

string decipherText(string str) {
    string decipher = "", temp = "";

    for (int i = 0; i < str.size(); i++) {
        if (isalpha(str[i])) {
            temp += str[i];

            if (decoder.find(temp) != decoder.end()) {
                decipher += decoder[temp];
                temp = "";
            }
        }
        else {
            decipher += str[i];
        }
    }

    return decipher;
}

int main() {
    ifstream input;
    input.open("polygon.txt");
    string str, cipher, decipher; 
    getline(input, str);


    createDictionary();

    

    cipher = cipherText(str);
    decipher = decipherText(cipher);

    cout << "Plain-Text: " << str << endl;
    cout << "Cipher-Text: " << cipher << endl;
    cout << "Decipher-Text: " << decipher << endl;


    return 0;
}